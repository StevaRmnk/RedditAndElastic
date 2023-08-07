import { TestBed } from '@angular/core/testing';

import { KorisnikservisService } from './korisnikservis.service';

describe('KorisnikservisService', () => {
  let service: KorisnikservisService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KorisnikservisService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
