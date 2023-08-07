import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzmenaobjaveComponent } from './izmenaobjave.component';

describe('IzmenaobjaveComponent', () => {
  let component: IzmenaobjaveComponent;
  let fixture: ComponentFixture<IzmenaobjaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzmenaobjaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IzmenaobjaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
