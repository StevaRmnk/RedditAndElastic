import { TestBed } from '@angular/core/testing';

import { ObjaveservisService } from './objaveservis.service';

describe('ObjaveservisService', () => {
  let service: ObjaveservisService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ObjaveservisService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
