import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ZahtevZajednice } from '../dodajzajednicustranica/dodajzajednicustranica.zahtevzajednice';
import { Zajednica } from '../kartica-objave/kartica-objave.component';
import { authService } from '../servisi/auth.service';
import { ZajedniceservisService } from '../servisi/zajedniceservis.service';

@Component({
  selector: 'app-izmenizajednicu',
  templateUrl: './izmenizajednicu.component.html',
  styleUrls: ['./izmenizajednicu.component.css']
})
export class IzmenizajednicuComponent implements OnInit {

  izmeniZajednicuForma = new FormGroup({});
  podaciIzmene!:ZahtevZajednice;
  mojazajednica!:Zajednica
  idZaj!:number

  constructor(private httpClient:HttpClient,private route: ActivatedRoute,private zajednicaServis: ZajedniceservisService,private ruter:Router,private authServis:authService) {
    this.mojazajednica= {
      idZajednice:0,
      imeZajednice:"",
      opisZajednice:"",
      listaObjavi:[]
    }
    this.podaciIzmene={
      imeZajednice:"",
      opisZajednice:""
    }
   }

  ngOnInit(): void {
    this.idZaj = this.route.snapshot.params['idZajednice']
    this.mojazajednica.idZajednice = this.idZaj
    this.nadjiZajednicuprekoId()

    this.izmeniZajednicuForma = new FormGroup({
      imeZajednice:new FormControl(""),
      opisZajednice:new FormControl("" )
    })
    
  }

  private nadjiZajednicuprekoId() {
    this.zajednicaServis.nadjiZajednicu(this.idZaj).subscribe(data => {
      this.mojazajednica = data;
      console.log(data)
    });
  }

  izmeniZajednicu(){
    if(this.authServis.tokenPostoji()){
      this.podaciIzmene.imeZajednice = this.izmeniZajednicuForma.get("imeZajednice")?.value;
    if(this.izmeniZajednicuForma.get("imeZajednice")?.value == null || this.izmeniZajednicuForma.get("imeZajednice")?.value == ""){
      this.podaciIzmene.imeZajednice = this.mojazajednica.imeZajednice
    }
    this.podaciIzmene.opisZajednice = this.izmeniZajednicuForma.get("opisZajednice")?.value
    if(this.izmeniZajednicuForma.get("opisZajednice")?.value == null || this.izmeniZajednicuForma.get("opisZajednice")?.value == ""){
      this.podaciIzmene.opisZajednice = this.mojazajednica.opisZajednice
    }

    this.zajednicaServis.izmeniZajednicu(this.podaciIzmene,this.idZaj).subscribe(data =>{
      console.log(data)
      this.ruter.navigate(["/homeStranica"]) 
    })
  }else{
    alert("Morate se ulogovati da bi vam bila dostupna ova opcija!")
  }
    }
    

}
