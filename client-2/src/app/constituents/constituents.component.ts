import { Component, OnInit } from '@angular/core';
import { ConstituentsService } from './constituents.service';
import { Constituent } from './constituent';

@Component({
  selector: 'app-constituents',
  templateUrl: './constituents.component.html',
  styleUrls: ['./constituents.component.scss']
})
export class ConstituentsComponent implements OnInit {


  constituents: Array<any>;
  name: String = "teste";

  constructor(
    private constituentService: ConstituentsService
  ) { }

  ngOnInit() {
    this.constituentService.getBySos(1).subscribe(data=>{
      console.log(data);
    })
  }


  setConstituents(){
    this.constituentService.getAll().subscribe(data=>{
      this.constituents = data;
    })
  }
}
