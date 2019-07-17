import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-sos',
  templateUrl: './sos.component.html',
  styleUrls: ['./sos.component.scss']
})
export class SosComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

}
