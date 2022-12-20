import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoyerPayesComponent } from './loyer-payes.component';

describe('LoyerPayesComponent', () => {
  let component: LoyerPayesComponent;
  let fixture: ComponentFixture<LoyerPayesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoyerPayesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoyerPayesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
