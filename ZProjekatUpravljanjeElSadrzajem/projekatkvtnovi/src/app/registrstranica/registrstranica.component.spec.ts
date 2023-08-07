import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrstranicaComponent } from './registrstranica.component';

describe('RegistrstranicaComponent', () => {
  let component: RegistrstranicaComponent;
  let fixture: ComponentFixture<RegistrstranicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrstranicaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrstranicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
