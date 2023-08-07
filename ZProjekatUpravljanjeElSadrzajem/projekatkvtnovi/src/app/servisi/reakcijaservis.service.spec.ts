import { TestBed } from '@angular/core/testing';

import { ReakcijaservisService } from './reakcijaservis.service';

describe('ReakcijaservisService', () => {
  let service: ReakcijaservisService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReakcijaservisService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
