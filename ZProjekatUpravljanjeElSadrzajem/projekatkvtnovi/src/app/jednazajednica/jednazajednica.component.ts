import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Objava, Zajednica } from '../kartica-objave/kartica-objave.component';
import { authService } from '../servisi/auth.service';
import { ZajedniceservisService } from '../servisi/zajedniceservis.service';

@Component({
  selector: 'app-jednazajednica',
  templateUrl: './jednazajednica.component.html',
  styleUrls: ['./jednazajednica.component.css']
})
export class JednazajednicaComponent implements OnInit {

  idZaj! : number
  mojazajednica!:Zajednica
  objaveZajednice!:Objava[]

  constructor(private httpClient:HttpClient,private route: ActivatedRoute,private zajednicaServis: ZajedniceservisService,private ruter:Router,private authServis:authService) {
    this.mojazajednica= {
      idZajednice:0,
      imeZajednice:"",
      opisZajednice:"",
      listaObjavi:[]

    }
   }

  ngOnInit(){
    this.idZaj = this.route.snapshot.params['idZajednice']
    this.mojazajednica.idZajednice = this.idZaj
    this.nadjiZajednicuprekoId()
    this.nadjiObjaveZajednice();
      
  }

  
  private nadjiZajednicuprekoId() {
    this.zajednicaServis.nadjiZajednicu(this.idZaj).subscribe(data => {
      this.mojazajednica = data;
      console.log(data)
    });
  }
  
  private nadjiObjaveZajednice(){
    this.zajednicaServis.nadjiObjaveZajednice(this.idZaj).subscribe(data =>{
      this.objaveZajednice = data;
      console.log(data) 
    })
  }
}
