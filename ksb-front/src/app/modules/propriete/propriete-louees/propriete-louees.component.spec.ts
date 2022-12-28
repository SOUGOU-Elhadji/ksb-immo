import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProprieteLoueesComponent } from './propriete-louees.component';

describe('ProprieteLoueesComponent', () => {
  let component: ProprieteLoueesComponent;
  let fixture: ComponentFixture<ProprieteLoueesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProprieteLoueesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProprieteLoueesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
