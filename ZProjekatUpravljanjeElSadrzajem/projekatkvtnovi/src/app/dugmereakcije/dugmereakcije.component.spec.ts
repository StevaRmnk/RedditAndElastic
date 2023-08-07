import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DugmereakcijeComponent } from './dugmereakcije.component';

describe('DugmereakcijeComponent', () => {
  let component: DugmereakcijeComponent;
  let fixture: ComponentFixture<DugmereakcijeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DugmereakcijeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DugmereakcijeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
