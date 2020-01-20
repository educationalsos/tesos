import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sos } from './sos';

@Component({
  selector: 'app-sos',
  templateUrl: './sos.component.html',
  styleUrls: ['./sos.component.scss']
})
export class SosComponent implements OnInit {

  constructor(private http: HttpClient) { }

  sos = new Sos("","","");
  ngOnInit() {
  }

}
