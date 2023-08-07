import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MojprofilstranicaComponent } from './mojprofilstranica.component';

describe('MojprofilstranicaComponent', () => {
  let component: MojprofilstranicaComponent;
  let fixture: ComponentFixture<MojprofilstranicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MojprofilstranicaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MojprofilstranicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
