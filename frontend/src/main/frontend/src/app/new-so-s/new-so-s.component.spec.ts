import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewSoSComponent } from './new-so-s.component';

describe('NewSoSComponent', () => {
  let component: NewSoSComponent;
  let fixture: ComponentFixture<NewSoSComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewSoSComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewSoSComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
