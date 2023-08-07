import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { KorisnikDTO } from '../mojprofilstranica/korisnikDTO';
import { authService } from '../servisi/auth.service';
import { KorisnikServisService } from '../servisi/korisnik-servis.service';
import { izmenaKorisnikaDTO } from './izmenaDTO';

@Component({
  selector: 'app-izmenakorisnika',
  templateUrl: './izmenakorisnika.component.html',
  styleUrls: ['./izmenakorisnika.component.css']
})
export class IzmenakorisnikaComponent implements OnInit {

  korisnickoIme!:string
  korisnikZaPregled!: KorisnikDTO
  podaciIzmene!:izmenaKorisnikaDTO
  izmeniKorisnikaForma = new FormGroup({})

  constructor(private authServis:authService,private korisnikServis: KorisnikServisService,private ruter:Router) {
    this.korisnikZaPregled={
      korisnickoIme:"",
      datumRegistracije :"",
      email:"",
      opis:""
    }
    this.podaciIzmene={
      email:"",
      opis:""
    }
   }

  ngOnInit(): void {
    this.korisnickoIme = this.authServis.nadjiKorisnickoIme()
    this.nadjiKorisnika()

    this.izmeniKorisnikaForma = new FormGroup({
      email: new FormControl(""),
      opisKorisnika: new FormControl("") 
    })

  }

  nadjiKorisnika(){
    this.korisnikServis.nadjiJednogKorisnika(this.korisnickoIme).subscribe(data=>{
      console.log(data)
      this.korisnikZaPregled = data;
    })
  }

  naIzmenu(){
    this.ruter.navigateByUrl("/izmeniLozinku")
  }

  izmeni(){
    this.podaciIzmene.email = this.izmeniKorisnikaForma.get('email')?.value
    console.log(this.podaciIzmene.email)
    if(this.izmeniKorisnikaForma.get('email')?.value == null || this.izmeniKorisnikaForma.get('email')?.value == ""){
      this.podaciIzmene.email = this.korisnikZaPregled.email
    }
    this.podaciIzmene.opis = this.izmeniKorisnikaForma.get('opisKorisnika')?.value
    console.log(this.podaciIzmene.opis)
    if(this.izmeniKorisnikaForma.get('opisKorisnika')?.value == null || this.izmeniKorisnikaForma.get('opisKorisnika')?.value==""){
      this.podaciIzmene.opis = this.korisnikZaPregled.opis
    }
    this.korisnikServis.izmeniKorisnika(this.podaciIzmene,this.korisnickoIme).subscribe(data=>{
      console.log(data)
      this.ruter.navigateByUrl("/homeStranica")
    })
  }
  

}
