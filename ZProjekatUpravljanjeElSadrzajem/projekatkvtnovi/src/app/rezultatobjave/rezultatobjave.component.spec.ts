import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RezultatobjaveComponent } from './rezultatobjave.component';

describe('RezultatobjaveComponent', () => {
  let component: RezultatobjaveComponent;
  let fixture: ComponentFixture<RezultatobjaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RezultatobjaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RezultatobjaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
