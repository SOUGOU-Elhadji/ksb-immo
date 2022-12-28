import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewApporteurComponent } from './new-apporteur.component';

describe('NewApporteurComponent', () => {
  let component: NewApporteurComponent;
  let fixture: ComponentFixture<NewApporteurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewApporteurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewApporteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
