import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sos } from './sos';
import { SosService } from './sos.service';
import { ServicesService } from '../services/services.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-sos',
  templateUrl: './sos.component.html',
  styleUrls: ['./sos.component.scss']
})
export class SosComponent implements OnInit {
  encodedFile: string;
  sos: Sos
  missions:  Map<number, Array<string>>;
  behaviors:  Map<number, Array<string>>;


  constructor(private sosService: SosService, private servicesService:ServicesService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      let id = Number(params.get('id'));
      this.sosService.get(id).subscribe((data: Sos)=> {
        this.sos = data;
      }, error => console.error(error), () =>{
        this.missions = new Map<number, Array<string>>();
        this.behaviors = new Map<number, Array<string>>();
        this.sosService.getMkaosModel(btoa(this.sos.mkaos_model)).subscribe(data=>{
          this.encodedFile = data;
        },error => console.error(error), () =>{
          let auxm = new Array<string>();
          let auxb = new Array<string>();
          var logLines = this.encodedFile.split(/[\r\n]+/);
          logLines.forEach(line=>{
            var pos = line.indexOf("Mission");
            if(pos >0){
              var start = line.indexOf("name=");
              var end = line.indexOf("refined");
              var str = line.slice(start+6, end-2);
              str.replace(/["]/g,'')
              auxm.push(str);
            }
            else{
              pos = line.indexOf("EmergentBehavior")
              if(pos > 0){
                var start = line.indexOf("name=");
                var str = line.slice(start+6, -3);
                auxb.push(str);
              }
            }
          })
          this.missions.set(this.sos.id, auxm);
          this.behaviors.set(this.sos.id, auxb)
        });
       
  
      });
    })
    
    


  }

  remove(id: number) {
    this.sosService.remove(id).subscribe();
  }



}
