import { Component, OnInit } from '@angular/core';
import { MissionsService } from './missions.service';
import { Mission } from './mission';

@Component({
  selector: 'app-missions',
  templateUrl: './missions.component.html',
  styleUrls: ['./missions.component.scss']
})
export class MissionsComponent implements OnInit {
  missions: Array<any>;
  
  constructor(
    private missionService: MissionsService
  ) { }

  ngOnInit() {
  }
}
