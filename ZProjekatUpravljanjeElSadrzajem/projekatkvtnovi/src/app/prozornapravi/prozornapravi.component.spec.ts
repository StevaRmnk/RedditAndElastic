import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProzornapraviComponent } from './prozornapravi.component';

describe('ProzornapraviComponent', () => {
  let component: ProzornapraviComponent;
  let fixture: ComponentFixture<ProzornapraviComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProzornapraviComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProzornapraviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
