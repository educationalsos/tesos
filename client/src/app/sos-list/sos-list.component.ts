import { Component, OnInit } from '@angular/core';
import { SosService } from '../sos/sos.service'
import { ServicesService } from 'app/services/services.service';


@Component({
  selector: 'app-sos-list',
  templateUrl: './sos-list.component.html',
  styleUrls: ['./sos-list.component.scss']
})
export class SosListComponent implements OnInit {

  soss: Array<any>;
  stakes:Array<any>;

  constructor(private sosService: SosService, private servicesService:ServicesService) { }

  ngOnInit() {
    this.sosService.getAll().subscribe(data=> {
      this.soss = data;
      
    });

    this.soss.forEach(sos => {
      this.stakes.push(this.servicesService.get(1));
      
    });

  }

  remove(id: number) {
    this.sosService.remove(id).subscribe();
  }

}
