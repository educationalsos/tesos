import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComunicationalCapabilitiesComponent } from './comunicationalCapabilities.component';

describe('ComunicationalCapabilitiesComponent', () => {
  let component: ComunicationalCapabilitiesComponent;
  let fixture: ComponentFixture<ComunicationalCapabilitiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComunicationalCapabilitiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComunicationalCapabilitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
