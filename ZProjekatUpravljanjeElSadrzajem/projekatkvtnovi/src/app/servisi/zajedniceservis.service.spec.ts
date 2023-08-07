import { TestBed } from '@angular/core/testing';

import { ZajedniceservisService } from './zajedniceservis.service';

describe('ZajedniceservisService', () => {
  let service: ZajedniceservisService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZajedniceservisService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
