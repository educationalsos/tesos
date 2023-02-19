import { Component, OnInit } from '@angular/core';
import { BehaviorsService } from './behaviors.service';
import { Behavior } from './behavior';

@Component({
  selector: 'app-behaviors',
  templateUrl: './behaviors.component.html',
  styleUrls: ['./behaviors.component.scss']
})
export class BehaviorsComponent implements OnInit {
  behaviors: Array<any>;
  
  constructor(
    private behaviorService: BehaviorsService
  ) { }

  ngOnInit() {
  }
}
