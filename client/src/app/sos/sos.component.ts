import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sos } from './sos';
import { SosService } from './sos.service';
import { ServicesService } from '../services/services.service';
import { ActivatedRoute } from '@angular/router';
import { Service } from 'app/services/service';
import { ComunicationalCapabilitiesService } from 'app/comunicationalCapability/comunicationalCapabilities.service';
import { MissionsService } from 'app/missions/missions.service';
import { Mission } from 'app/missions/mission';
import { ComunicationalCapability } from 'app/comunicationalCapability/comunicationalCapability';

@Component({
  selector: 'app-sos',
  templateUrl: './sos.component.html',
  styleUrls: ['./sos.component.scss']
})
export class SosComponent implements OnInit {
  encodedFile: string;
  sos: Sos
  coverage: Number
  unitCoverage: Number
  integrationCoverage: Number
  systemCoverage: Number

  constructor(
    private sosService: SosService, 
    private servicesService:ServicesService, 
    private comunicationalCapabilityService:ComunicationalCapabilitiesService, 
    private missionService:MissionsService, 
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      let id = Number(params.get('id'));
      this.sosService.get(id).subscribe((data: Sos)=> {
        console.log(data)
        this.sos = data;
      }, error => console.error(error), () =>{
        let aux_p = 0;
        let aux_l = 0;
        this.sos.constituents.map(constituent =>{
          aux_p += constituent.services.filter(serv => serv.satisfied).length 
          aux_l += constituent.services.length
        })
        this.unitCoverage = Math.round(aux_p * 100 / aux_l)
        aux_p = 0;
        aux_l = 0;
        this.sos.behaviors.map(behavior =>{
          aux_p += behavior.comunicationalCapabilities.filter(serv => serv.satisfied).length 
          aux_l += behavior.comunicationalCapabilities.length
        })
        this.integrationCoverage = Math.round(aux_p * 100 / aux_l)
        this.systemCoverage = Math.round(this.sos.missions.filter(serv => serv.satisfied).length * 100 / this.sos.missions.length)
        this.coverage = this.unitCoverage
      });

      
      
    })
  }

  onCheckUnit(serv: Service){
    serv.satisfied = !serv.satisfied
    this.servicesService.update(serv).subscribe(data =>{
    },error => console.error(error), () =>{
      this.sosService.get(this.sos.id).subscribe((data: Sos)=> {
        this.sos = data;
      }, error => console.error(error), () =>{
        let aux_p = 0;
        let aux_l = 0;
        this.sos.constituents.map(constituent =>{
          aux_p += constituent.services.filter(serv => serv.satisfied).length 
          aux_l += constituent.services.length
        })
        this.unitCoverage = Math.round(aux_p * 100 / aux_l)
        this.coverage = this.unitCoverage
      }); 
    });
  }

  onCheckIntegration(capability: ComunicationalCapability){
    capability.satisfied = !capability.satisfied
    this.comunicationalCapabilityService.update(capability).subscribe(data =>{
    },error => console.error(error), () =>{
      this.sosService.get(this.sos.id).subscribe((data: Sos)=> {
        this.sos = data;
      }, error => console.error(error), () =>{
        let aux_p = 0;
        let aux_l = 0;
        this.sos.behaviors.map(behavior =>{
          aux_p += behavior.comunicationalCapabilities.filter(serv => serv.satisfied).length 
          aux_l += behavior.comunicationalCapabilities.length
        })
        this.integrationCoverage = Math.round(aux_p * 100 / aux_l)
        this.coverage = this.integrationCoverage
      }); 
    });
  }

  onCheckSystem(mission: Mission){
    mission.satisfied = !mission.satisfied
    this.missionService.update(mission).subscribe(data =>{
    },error => console.error(error), () =>{
      this.sosService.get(this.sos.id).subscribe((data: Sos)=> {
        this.sos = data;
      }, error => console.error(error), () =>{
        this.systemCoverage = Math.round(this.sos.missions.filter(serv => serv.satisfied).length * 100 / this.sos.missions.length)
        this.coverage = this.systemCoverage
      }); 
    });
  }

  changeCoverage(nav: String){
    switch (nav) {
      case "unit":
        this.coverage = this.unitCoverage
        break;
      case "integration":
        this.coverage = this.integrationCoverage
        break;
      case "system":
        this.coverage = this.systemCoverage
        break;
      default:
        break;
    }
  }

  remove(id: number) {
    this.sosService.remove(id).subscribe();
  }



}
