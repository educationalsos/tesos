import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConstituentsComponent } from './constituents.component';

describe('ConstituentsComponent', () => {
  let component: ConstituentsComponent;
  let fixture: ComponentFixture<ConstituentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConstituentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConstituentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
