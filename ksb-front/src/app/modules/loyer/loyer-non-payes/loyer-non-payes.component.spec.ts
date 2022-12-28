import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoyerNonPayesComponent } from './loyer-non-payes.component';

describe('LoyerNonPayesComponent', () => {
  let component: LoyerNonPayesComponent;
  let fixture: ComponentFixture<LoyerNonPayesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoyerNonPayesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoyerNonPayesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
