import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, NgForm } from '@angular/forms';
import { Subscription } from 'rxjs/Subscription';
import { SosService } from 'app/sos/sos.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Sos } from 'app/sos/sos';
import { Stakeholder } from 'app/stakeholders/stakeholder';
import { forEach } from '@angular/router/src/utils/collection';
import { StakeholdersService } from 'app/stakeholders/stakeholders.service';
import { Constituent } from 'app/constituents/constituent';
import { ConstituentsService } from 'app/constituents/constituents.service';
import { Service } from 'app/services/service';
import { ServicesService } from 'app/services/services.service';
import { AuxService } from 'app/services/auxservice';


@Component({
  selector: 'app-new-so-s',
  templateUrl: './new-so-s.component.html',
  styleUrls: ['./new-so-s.component.scss']
})
export class NewSoSComponent implements OnInit {
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;

  sos: Sos = {
    id: null,
    name: "",
    description:"",
    mkaos_model: ""
  };



  stakeholder: Stakeholder = {
    name:"",
    sos:null
  }

  constituent: Constituent = {
    id: null,
    path: "",
    services:null,
    sos: null
  }

  mkaos_model_to_upload: File = null
  constituents_models_to_upload: Array<File> = []

  model_services: Array<Array<Service>> = []
  stakeholders: Array<Stakeholder> = []
  constituents: Array<Constituent> = []

  constructor(
    private _formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private sosService: SosService,
    private servicesService: ServicesService,
    private stakeholderService: StakeholdersService,
    private constituentService: ConstituentsService
    ) { }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
  }

  gotoList() {
    this.router.navigate(['/list']);
  }

  save() {
    this.sosService.save(this.sos).subscribe(result => {
      this.sos.id = result;
    }, error => console.error(error), () =>{
      this.saveStake();
      this.saveConstituentsAndServices();
      this.router.navigate(['/list']);
    });
  
    this.uploadFile('1',this.mkaos_model_to_upload);
    this.constituents_models_to_upload.forEach(file => {
      this.uploadFile('2',file);      
    });
    
  }

  remove(href) {
    this.sosService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  addStake(){
    const aux = new Stakeholder(this.stakeholder.name, null);
    this.stakeholders.push(aux);
  }

  removeStake(index: number){
    this.stakeholders.splice(index, 1)

  }

  saveStake(){
    this.stakeholders.forEach(stake => {
      stake.sos = this.sos;
      this.stakeholderService.save(stake).subscribe(result => {
      }, error => console.error(error));
    });
  }

  saveConstituents(){
    this.constituents.forEach(model => {
      this.constituentService.save(model).subscribe(result => {
      }, error => console.error(error));
    });
  }

  saveConstituentsAndServices(){
    for (let i = 0; i < this.constituents.length; i++) {
      this.constituents[i].sos = this.sos;
      this .constituentService.save(this.constituents[i]).subscribe(result =>{
        this.constituents[i].id = result;
      }, error => console.error(error),
      ()=>{
        for (let j = 0; j < this.model_services[i].length; j++) {
          this.model_services[i][j].model = this.constituents[i];
          this.servicesService.save(this.model_services[i][j]).subscribe(result=>{
          }, error => console.error(error));
        }
      })
      
    }
  }
  handleMkaosModel(files: FileList) {
    this.mkaos_model_to_upload = files.item(0);
    this.sos.mkaos_model = "../uploads/mkaos_models/"+this.sos.name+"/"+files.item(0).name;
  }
  
  handleConstituintsModels(files: FileList) {
    for (let i = 0; i < files.length; i++) {
      this.constituents_models_to_upload.push(files.item(i));
      const aux = new Constituent(null,"../uploads/constituents_models/"+this.sos.name+"/"+files.item(i).name, null, null);
      this.constituents.push(aux);
    }
    
    
  }

  uploadFile(type: string, file: File){
    let formData = new FormData(); 
    formData.append('file', file);
    formData.append('name', this.sos.name);
    formData.append('type', type);
    this.sosService.upload(formData).subscribe(result => {
    }, error => console.error(error));;
  }
  
  handleServices(){
    for (let i = 0; i < this.constituents.length; i++) {
      this.model_services.push(this.readServices(new Array<Service>(), i)) ;
    }
    
    
  }

  readServices(services: Array<Service>, i: number){
    let r = new FileReader();
    r.readAsText(this.constituents_models_to_upload[i]);

    r.onload = function(e) {
      var rawLog = r.result;
      var logLines = (rawLog as string).split(/[\r\n]+/);
      logLines.forEach(line=>{
        var pos = line.indexOf("name=");
        var line1 = line.indexOf("capableOf=");
        if(pos >0 && line1 <0)
          services.push(new Service(null,line.slice(pos+6, -3),"", null))
      })     
    };
    //services.shift();
    return services;

  }


}
