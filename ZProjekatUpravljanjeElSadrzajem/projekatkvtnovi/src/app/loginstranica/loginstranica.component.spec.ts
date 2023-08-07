import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginstranicaComponent } from './loginstranica.component';

describe('LoginstranicaComponent', () => {
  let component: LoginstranicaComponent;
  let fixture: ComponentFixture<LoginstranicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginstranicaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginstranicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
