import { Component, OnInit } from '@angular/core';
import { SosService } from '../sos/sos.service'
import { ConstituentsService } from 'app/constituents/constituents.service';
import { StakeholdersService } from 'app/stakeholders/stakeholders.service';

@Component({
  selector: 'app-sos-list',
  templateUrl: './sos-list.component.html',
  styleUrls: ['./sos-list.component.scss']
})
export class SosListComponent implements OnInit {

  soss: Array<any>;


  constructor(private sosService: StakeholdersService) { }

  ngOnInit() {
    this.sosService.getAll().subscribe(data=> {
      this.soss = data;
    });

  }

  remove(id: number) {
    this.sosService.remove(id).subscribe();
  }

}
