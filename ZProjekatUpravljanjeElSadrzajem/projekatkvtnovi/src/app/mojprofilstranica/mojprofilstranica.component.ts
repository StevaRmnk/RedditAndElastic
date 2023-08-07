import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Korisnik } from '../kartica-objave/kartica-objave.component';
import { authService } from '../servisi/auth.service';
import { KorisnikServisService } from '../servisi/korisnik-servis.service';
import { KorisnikDTO } from './korisnikDTO';

@Component({
  selector: 'app-mojprofilstranica',
  templateUrl: './mojprofilstranica.component.html',
  styleUrls: ['./mojprofilstranica.component.css']
})
export class MojprofilstranicaComponent implements OnInit {

  korisnickoIme!:string
  korisnikZaPregled!: KorisnikDTO
  karmaKorisnika!:number

  constructor(private authServis:authService,private korisnikServis: KorisnikServisService,private ruter:Router,private httpClient:HttpClient) {
    this.korisnikZaPregled={
      korisnickoIme:"",
      datumRegistracije:"",
      email:"",
      opis:""
    }
   }

  ngOnInit(): void {
    this.korisnickoIme = this.authServis.nadjiKorisnickoIme()
    this.nadjiKorisnika()
    this.nadjiKarmuKorisnika()
  }

  nadjiKorisnika(){
    this.korisnikServis.nadjiJednogKorisnika(this.korisnickoIme).subscribe(data=>{
      console.log(data)
      this.korisnikZaPregled = data;
      console.log(this.korisnikZaPregled)
    })
  }

  nadjiKarmuKorisnika(){
    return this.krmKorisnika(this.korisnickoIme).subscribe(data=>{
      console.log(data)
      this.karmaKorisnika = data
    })
  }

  krmKorisnika(korisnickoIme:string):Observable<any>{
    return this.httpClient.get<number>('http://localhost:8080/reactions/karmaKor/'+korisnickoIme)
  }

  idiNaIzmenu(){
    this.ruter.navigateByUrl("/izmenaProfila")
  }

  

}
