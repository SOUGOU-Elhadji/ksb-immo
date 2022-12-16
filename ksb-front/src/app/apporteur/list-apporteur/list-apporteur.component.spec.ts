import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListApporteurComponent } from './list-apporteur.component';

describe('ListApporteurComponent', () => {
  let component: ListApporteurComponent;
  let fixture: ComponentFixture<ListApporteurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListApporteurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListApporteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
