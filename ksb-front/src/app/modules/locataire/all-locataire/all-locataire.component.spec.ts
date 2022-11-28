import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllLocataireComponent } from './all-locataire.component';

describe('AllLocataireComponent', () => {
  let component: AllLocataireComponent;
  let fixture: ComponentFixture<AllLocataireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllLocataireComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllLocataireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
