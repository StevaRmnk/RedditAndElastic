import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JednaobjavaComponent } from './jednaobjava.component';

describe('JednaobjavaComponent', () => {
  let component: JednaobjavaComponent;
  let fixture: ComponentFixture<JednaobjavaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JednaobjavaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JednaobjavaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
