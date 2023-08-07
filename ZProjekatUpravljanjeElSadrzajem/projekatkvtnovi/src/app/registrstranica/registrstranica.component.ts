import { Component, OnInit } from '@angular/core';
import { EmailValidator, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { min } from 'rxjs';
import { RegistracioniservisService } from '../servisi/registracioniservis.service';
import { zahtevRegistracije } from './registrstranica.zahtevRegistracije';

@Component({
  selector: 'app-registrstranica',
  templateUrl: './registrstranica.component.html',
  styleUrls: ['./registrstranica.component.css']
})
export class RegistrstranicaComponent implements OnInit {


  registracionaForma: FormGroup = new FormGroup({});
  zahtevRegistracije!: zahtevRegistracije;
  constructor(private registracioniServisService: RegistracioniservisService,private ruter:Router) {
    this.zahtevRegistracije = { 
      korisnickoIme:"",
      email:"",
      lozinka:"",

    } 
  }

  ngOnInit() {
    this.registracionaForma = new FormGroup({
      email: new FormControl("",Validators.required),
      korisnickoIme: new FormControl("",[Validators.required,Validators.minLength(2)]),
      lozinka: new FormControl("",Validators.required),

      
    })
  }
    

  registrujSe(){
    this.zahtevRegistracije.email = this.registracionaForma.get('email')?.value;
    this.zahtevRegistracije.korisnickoIme = this.registracionaForma.get('korisnickoIme')?.value;
    this.zahtevRegistracije.lozinka = this.registracionaForma.get('lozinka')?.value;

    this.registracioniServisService.registrujSe(this.zahtevRegistracije).subscribe(data => {
      console.log(data)
      this.ruter.navigateByUrl("/homeStranica")
    })

  }



}
