import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { of } from 'rxjs/internal/observable/of';
import { Observable } from 'rxjs';
import { LoginDTO } from '../loginstranica/loginzahtev';
import { LoginOdgovorDTO } from '../loginstranica/loginodgovor';

@Injectable({
    providedIn: 'root'
  })
  export class authService {

    constructor(private httpClient : HttpClient,private ruter: Router) { }

    private access_token = null;

    login(logovanje : LoginDTO){
       return this.httpClient.post<LoginOdgovorDTO>('http://localhost:8080/users/login',logovanje).pipe(map((odgovor)=>{
            console.log("Uspesno ulogovani!");
            this.access_token = odgovor.accessToken;
            console.log(this.access_token)
            localStorage.setItem("JsonToken", odgovor.accessToken)
        }))

    }

    logout() {
        localStorage.removeItem('JsonToken')
        this.ruter.navigateByUrl('/homeStranica');
    }

    tokenPostoji(): Boolean {
        let token = this.nadjiToken()
        return token != null;
    }

    nadjiToken() {
        let token = localStorage.getItem('JsonToken');
        return token
    }

    nadjiKorisnickoIme(): string {
        let token = this.parseToken();
    
        if (token) {
          return this.parseToken()['sub']
        }
        return "";
      }
    
      private parseToken() {
        let jwt = localStorage.getItem('JsonToken');
        if (jwt !== null) {
          let jwtData = jwt.split('.')[1];
          let decodedJwtJsonData = atob(jwtData);
          let decodedJwtData = JSON.parse(decodedJwtJsonData);
          return decodedJwtData;
        }
    }

  }
