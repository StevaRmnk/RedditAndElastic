import { TestBed } from '@angular/core/testing';

import { RegistracioniservisService } from './registracioniservis.service';

describe('RegistracioniservisService', () => {
  let service: RegistracioniservisService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistracioniservisService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
