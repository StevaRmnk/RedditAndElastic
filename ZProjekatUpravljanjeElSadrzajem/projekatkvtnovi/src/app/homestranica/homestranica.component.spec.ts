import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomestranicaComponent } from './homestranica.component';

describe('HomestranicaComponent', () => {
  let component: HomestranicaComponent;
  let fixture: ComponentFixture<HomestranicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomestranicaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomestranicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
