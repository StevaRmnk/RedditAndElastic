import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZajednicastranicaComponent } from './zajednicastranica.component';

describe('ZajednicastranicaComponent', () => {
  let component: ZajednicastranicaComponent;
  let fixture: ComponentFixture<ZajednicastranicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZajednicastranicaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZajednicastranicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
