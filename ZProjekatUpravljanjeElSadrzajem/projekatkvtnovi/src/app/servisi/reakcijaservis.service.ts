import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reakcija } from '../dugmereakcije/Reakcija';
import { Objava } from '../kartica-objave/kartica-objave.component';

@Injectable({
  providedIn: 'root'
})
export class ReakcijaservisService {

  reakcija!:Reakcija;

  constructor(private httpClient : HttpClient) { 

  }

  napraviReakciju(reakcija :Reakcija): Observable<any> {
    return this.httpClient.post('http://localhost:8080/reactions/', reakcija)
  }

  nadjiKarmuObjave(idObjave : number){
    return this.httpClient.get<any>('http://localhost:8080/reactions/karma/'+ idObjave)
  }
}
