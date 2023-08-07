import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Korisnik, Objava, Zajednica } from '../kartica-objave/kartica-objave.component';
import { authService } from '../servisi/auth.service';
import { ObjaveservisService } from '../servisi/objaveservis.service';
import { ReakcijaservisService } from '../servisi/reakcijaservis.service';

@Component({
  selector: 'app-jednaobjava',
  templateUrl: './jednaobjava.component.html',
  styleUrls: ['./jednaobjava.component.css']
})
export class JednaobjavaComponent implements OnInit {

  idObj!:number;
  mojaObjava!:Objava

  constructor(private httpClient:HttpClient,private route: ActivatedRoute,private objavaServis : ObjaveservisService,private reakcijaServis: ReakcijaservisService,
    private ruter:Router,private authServis:authService) {
    this.mojaObjava = {
      idObjave:0,
      naslovObjave:"",
      tekstObjave:"",
      datumKreiranja:"",
      putanjaDoSlike:"",
      autorObjave:"",
      zajednica:""
      
    }
   }

  ngOnInit(): void {
    this.idObj = this.route.snapshot.params['idObjave']
    this.mojaObjava.idObjave = this.idObj
    this.nadjiObjavuPrekoId()
  }

  nadjiObjavuPrekoId(){
    this.objavaServis.nadjiJednuObjavu(this.idObj).subscribe(data =>{
      this.mojaObjava = data;
      console.log(data)
    })
  }

  

  

  obrisiObjavu(){
    if(this.authServis.tokenPostoji()){
      this.objavaServis.obrisiObjavu(this.idObj).subscribe(data =>{
        this.ruter.navigateByUrl('/homeStranica'); 
      } ,error =>{
        console.log(error)
      })
    }else{
      alert("Morate se ulogovati da bi vam bila dostupna ova opcija!")
    }
    
  }

  izmeniObjavu(){
    if(this.authServis.tokenPostoji()){
      console.log(this.mojaObjava.idObjave)
    this.ruter.navigateByUrl("/izmenaObjave/"+this.mojaObjava.idObjave)
    }
    else{
      alert("Morate se ulogovati da bi vam bila dostupna ova opcija!")
    }
    
  }

}
