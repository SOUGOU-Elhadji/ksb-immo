import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProprieteComponent } from './update-propriete.component';

describe('UpdateProprieteComponent', () => {
  let component: UpdateProprieteComponent;
  let fixture: ComponentFixture<UpdateProprieteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateProprieteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateProprieteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
