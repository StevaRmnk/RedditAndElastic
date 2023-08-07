import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProzorcezajedniceComponent } from './prozorcezajednice.component';

describe('ProzorcezajedniceComponent', () => {
  let component: ProzorcezajedniceComponent;
  let fixture: ComponentFixture<ProzorcezajedniceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProzorcezajedniceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProzorcezajedniceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
