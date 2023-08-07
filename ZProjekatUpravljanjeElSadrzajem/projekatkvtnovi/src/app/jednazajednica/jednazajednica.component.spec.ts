import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JednazajednicaComponent } from './jednazajednica.component';

describe('JednazajednicaComponent', () => {
  let component: JednazajednicaComponent;
  let fixture: ComponentFixture<JednazajednicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JednazajednicaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JednazajednicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
