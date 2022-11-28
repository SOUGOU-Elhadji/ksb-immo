import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateProprieteComponent } from './create-propriete.component';

describe('CreateProprieteComponent', () => {
  let component: CreateProprieteComponent;
  let fixture: ComponentFixture<CreateProprieteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateProprieteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateProprieteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
