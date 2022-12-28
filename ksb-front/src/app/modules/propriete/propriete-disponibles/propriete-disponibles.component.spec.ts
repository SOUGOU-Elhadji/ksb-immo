import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProprieteDisponiblesComponent } from './propriete-disponibles.component';

describe('ProprieteDisponiblesComponent', () => {
  let component: ProprieteDisponiblesComponent;
  let fixture: ComponentFixture<ProprieteDisponiblesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProprieteDisponiblesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProprieteDisponiblesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
