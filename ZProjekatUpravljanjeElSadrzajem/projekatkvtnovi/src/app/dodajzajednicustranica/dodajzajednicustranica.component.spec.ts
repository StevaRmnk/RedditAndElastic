import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajzajednicustranicaComponent } from './dodajzajednicustranica.component';

describe('DodajzajednicustranicaComponent', () => {
  let component: DodajzajednicustranicaComponent;
  let fixture: ComponentFixture<DodajzajednicustranicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodajzajednicustranicaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajzajednicustranicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
