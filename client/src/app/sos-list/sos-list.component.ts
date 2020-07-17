import { Component, OnInit } from '@angular/core';
import { SosService } from '../sos/sos.service'
import { ServicesService } from 'app/services/services.service';

@Component({
  selector: 'app-sos-list',
  templateUrl: './sos-list.component.html',
  styleUrls: ['./sos-list.component.scss']
})
export class SosListComponent implements OnInit {
  encodedFile: string;
  soss: Array<any>;
  missions:  Map<number, Array<string>>;
  behaviors:  Map<number, Array<string>>;


  constructor(private sosService: SosService, private servicesService:ServicesService) { }

  ngOnInit() {
    this.sosService.getAll().subscribe(data=> {
      this.soss = data;
    }, error => console.error(error), () =>{
      this.missions = new Map<number, Array<string>>();
      this.behaviors = new Map<number, Array<string>>();
      this.soss.forEach(sos => {

        this.sosService.getMkaosModel(btoa(sos.mkaos_model)).subscribe(data=>{
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
              var str = line.slice(start+5, end);
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
          this.missions.set(sos.id, auxm);
          this.behaviors.set(sos.id, auxb)
        });
      });
     

    });


  }

  remove(id: number) {
    this.sosService.remove(id).subscribe();
  }


}



