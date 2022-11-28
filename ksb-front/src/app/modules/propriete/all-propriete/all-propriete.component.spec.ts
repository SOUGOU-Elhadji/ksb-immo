import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllProprieteComponent } from './all-propriete.component';

describe('AllProprieteComponent', () => {
  let component: AllProprieteComponent;
  let fixture: ComponentFixture<AllProprieteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllProprieteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllProprieteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
