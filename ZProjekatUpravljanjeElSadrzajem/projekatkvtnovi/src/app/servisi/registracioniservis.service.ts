import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { zahtevRegistracije } from '../registrstranica/registrstranica.zahtevRegistracije';

@Injectable({
  providedIn: 'root'
})
export class RegistracioniservisService {

  constructor(private httpClient: HttpClient) {
   }

   registrujSe(zahtevRegistracije: zahtevRegistracije):Observable<any>{
    return this.httpClient.post('http://localhost:8080/users/', zahtevRegistracije);
   }
}


