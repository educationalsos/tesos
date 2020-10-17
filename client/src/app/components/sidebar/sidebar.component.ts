import { Component, OnInit } from '@angular/core';
import { Sos } from 'app/sos/sos';
import { SosService } from 'app/sos/sos.service';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/sos', title: 'Educational SoS',  icon: 'grain', class: '' },
  { path: '/dashboard', title: 'Testing SoS',  icon: 'grain', class: '' },
  { path: '/user-profile', title: 'Health SoS',  icon: 'grain', class: '' }
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: Sos[];

  constructor(private sosService: SosService) { }

  ngOnInit() {
    this.sosService.getAll().subscribe(data=> {
      this.menuItems = data;
    }, error => console.error(error), () =>{});
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}
