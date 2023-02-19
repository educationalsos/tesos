import { Component, OnInit } from '@angular/core';
import { ComunicationalCapabilitiesService } from './comunicationalCapabilities.service';
import { ComunicationalCapability } from './comunicationalCapability';

@Component({
  selector: 'app-comunicationalCapabilities',
  templateUrl: './comunicationalCapabilities.component.html',
  styleUrls: ['./comunicationalCapabilities.component.scss']
})
export class ComunicationalCapabilitiesComponent implements OnInit {
  comunicationalCapabilities: Array<any>;
  
  constructor(
    private comunicationalCapabilityService: ComunicationalCapabilitiesService
  ) { }

  ngOnInit() {
  }
}
