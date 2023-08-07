import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzmenakorisnikaComponent } from './izmenakorisnika.component';

describe('IzmenakorisnikaComponent', () => {
  let component: IzmenakorisnikaComponent;
  let fixture: ComponentFixture<IzmenakorisnikaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzmenakorisnikaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IzmenakorisnikaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
