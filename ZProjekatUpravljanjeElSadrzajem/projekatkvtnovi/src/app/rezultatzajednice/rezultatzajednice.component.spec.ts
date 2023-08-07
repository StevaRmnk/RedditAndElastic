import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RezultatzajedniceComponent } from './rezultatzajednice.component';

describe('RezultatzajedniceComponent', () => {
  let component: RezultatzajedniceComponent;
  let fixture: ComponentFixture<RezultatzajedniceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RezultatzajedniceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RezultatzajedniceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
