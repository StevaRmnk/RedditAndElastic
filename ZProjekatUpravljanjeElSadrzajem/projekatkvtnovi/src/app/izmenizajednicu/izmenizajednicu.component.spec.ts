import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzmenizajednicuComponent } from './izmenizajednicu.component';

describe('IzmenizajednicuComponent', () => {
  let component: IzmenizajednicuComponent;
  let fixture: ComponentFixture<IzmenizajednicuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzmenizajednicuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IzmenizajednicuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
