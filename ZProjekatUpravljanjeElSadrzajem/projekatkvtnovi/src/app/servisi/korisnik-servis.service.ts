import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { izmenalozinkeDto } from '../izmena-lozinke/izmenalozinkeDTO';
import { izmenaKorisnikaDTO } from '../izmenakorisnika/izmenaDTO';
import { KorisnikDTO } from '../mojprofilstranica/korisnikDTO';

@Injectable({
  providedIn: 'root'
})
export class KorisnikServisService {

  constructor(private httpClient:HttpClient) { }

  nadjiJednogKorisnika(korisnickoIme: string):Observable<any>{
    return this.httpClient.get('http://localhost:8080/users/DTO/'+ korisnickoIme)
  }

  izmeniKorisnika(izmenjenDTO:izmenaKorisnikaDTO,korisnickoIme:string):Observable<any>{
    return this.httpClient.put('http://localhost:8080/users/update/'+ korisnickoIme, izmenjenDTO)
  }

  nadjiKorisnikaSaLozinkom(korisnickoIme:string):Observable<any>{
    return this.httpClient.get('http://localhost:8080/users/'+ korisnickoIme)
  }

  izmeniLozinku(izmenaLozinkaDTO:izmenalozinkeDto):Observable<any>{
    return this.httpClient.post('http://localhost:8080/users/lozinka/'+izmenaLozinkaDTO.korisnickoIme, izmenaLozinkaDTO)
  }

 
}
