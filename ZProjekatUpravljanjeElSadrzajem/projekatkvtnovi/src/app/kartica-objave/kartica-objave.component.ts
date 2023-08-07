import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ObjaveservisService } from '../servisi/objaveservis.service';



export class Objava{
  constructor(
    public idObjave: number,
    public naslovObjave: string,
    public tekstObjave: string,
    public datumKreiranja: String,
    public putanjaDoSlike: string,
    public autorObjave: string,
    public zajednica: string

  ){}

}

export class Korisnik{
  constructor(
    public korisnickoIme: string,
    public lozinka: string,
    public email: string,
    public avatar: string,
    public datumRegistracije: Date,
    public opis: string,
    public prikazanoIme: string
  ){}
}


export class Zajednica{
  constructor(
    public idZajednice: number,
    public imeZajednice: string,
    public opisZajednice: string,
    public listaObjavi : Objava[]
  ){}
}


@Component({
  selector: 'app-kartica-objave',
  templateUrl: './kartica-objave.component.html',
  styleUrls: ['./kartica-objave.component.css']
})
export class KarticaObjaveComponent implements OnInit {

  objave!:Objava[]
  @Input() jednaobjava!:Objava

  constructor(private httpClient:HttpClient,private router:Router,private objavaServis: ObjaveservisService) { }

  ngOnInit(): void {
    this.nadjiObjave();
  }

  nadjiObjave(){
    return this.httpClient.get<any>('http://localhost:8080/posts/DTO').subscribe(
      response =>
      {
        console.log(response)
        this.objave = response;
      }
    )
  }

  procitajObjavu(idObjave: number): void {
    this.router.navigateByUrl('/pregledJedneObjave/' + idObjave); 
  }


}
