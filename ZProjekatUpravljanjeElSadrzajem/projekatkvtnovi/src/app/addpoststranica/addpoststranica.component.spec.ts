import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddpoststranicaComponent } from './addpoststranica.component';

describe('AddpoststranicaComponent', () => {
  let component: AddpoststranicaComponent;
  let fixture: ComponentFixture<AddpoststranicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddpoststranicaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddpoststranicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
