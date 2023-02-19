import { Component, OnDestroy, OnInit } from '@angular/core';
import { UntypedFormBuilder, Validators} from '@angular/forms';
import { Subscription } from 'rxjs';
import { SosService } from 'app/sos/sos.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Sos } from 'app/sos/sos';
import { Stakeholder } from 'app/stakeholders/stakeholder';
import { StakeholdersService } from 'app/stakeholders/stakeholders.service';
import { Constituent } from 'app/constituents/constituent';
import { ConstituentsService } from 'app/constituents/constituents.service';
import { Service } from 'app/services/service';
import { ServicesService } from 'app/services/services.service';
import { AuxService } from 'app/services/auxservice';
import { MatStepper } from '@angular/material/stepper';


@Component({
  selector: 'app-new-so-s',
  templateUrl: './new-so-s.component.html',
  styleUrls: ['./new-so-s.component.scss']
})
export class NewSoSComponent {
  firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required]
  });
  secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required]
  });


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

  mkaos_model_to_upload: File = null
  mkaos_model_name: String = ""
  constituents_models_name: String = ""
  constituents_models_to_upload: Array<File> = []

  model_services: Array<Array<Service>> = []
  stakeholders: Array<Stakeholder> = []


  constructor(
    private _formBuilder: UntypedFormBuilder,
    private router: Router,
    private sosService: SosService,
    private servicesService: ServicesService,
    private stakeholderService: StakeholdersService,
    ) { }

  gotoHome() {
    this.router.navigate(['/home']);
  }

  save(stepper: MatStepper) {
    this.sosService.save(this.sos).subscribe(result => {
      this.sos.id = result;
    }, error => console.error(error), async () =>{
      this.saveStake();
      await this.uploadFile('1',this.mkaos_model_to_upload);
      await Promise.all(this.constituents_models_to_upload.map(async file => {
        await this.uploadFile('2',file);      
      }))
      this.sosService.get(this.sos.id).subscribe((data: Sos)=> {
        this.sos = data;
      }, error => console.error(error), () =>{
        stepper.next()
      });

    });
    
 
  }

  remove(href) {
    this.sosService.remove(href).subscribe(result => {
      this.gotoHome();
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

  goForward(stepper: MatStepper){
    stepper.next();
  }

  handleMkaosModel(files: FileList) {
    this.mkaos_model_to_upload = files.item(0);
    this.mkaos_model_name = files.item(0).name
    this.sos.mkaos_model = "../uploads/mission_models/"+this.sos.name+"/"+files.item(0).name;
  }
  
  handleConstituintsModels(files: FileList) {
    for (let i = 0; i < files.length; i++) {
      this.constituents_models_to_upload.push(files.item(i));
      if (i> 0) {
        this.constituents_models_name += ", "
      }
      this.constituents_models_name += files.item(i).name
    }
  }

  async updateServices(){
    await Promise.all(this.sos.constituents.map(async constituent => {
      await this.servicesService.update_all(constituent.services).toPromise();      
    }))

    this.router.navigate(['/sos', this.sos.id]);
  }

  async uploadFile(type: string, file: File){
    let formData = new FormData(); 
    formData.append('file', file);
    formData.append('sos_id', this.sos.id.toString());
    formData.append('type', type);
    await this.sosService.upload(formData).toPromise();
  }
}
