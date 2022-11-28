import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllAgenceComponent } from './all-agence.component';

describe('AllAgenceComponent', () => {
  let component: AllAgenceComponent;
  let fixture: ComponentFixture<AllAgenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllAgenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllAgenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
