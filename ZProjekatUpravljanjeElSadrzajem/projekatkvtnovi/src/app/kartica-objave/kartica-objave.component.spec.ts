import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KarticaObjaveComponent } from './kartica-objave.component';

describe('KarticaObjaveComponent', () => {
  let component: KarticaObjaveComponent;
  let fixture: ComponentFixture<KarticaObjaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KarticaObjaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KarticaObjaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
