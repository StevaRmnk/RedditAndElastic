import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Objava } from '../kartica-objave/kartica-objave.component';
import { ObjaveservisService } from '../servisi/objaveservis.service';
import { ReakcijaservisService } from '../servisi/reakcijaservis.service';
import { izmenaObjaveDTO } from './izmenaobjave.objDTO';

@Component({
  selector: 'app-izmenaobjave',
  templateUrl: './izmenaobjave.component.html',
  styleUrls: ['./izmenaobjave.component.css']
})
export class IzmenaobjaveComponent implements OnInit {
  
  izmeniObjavuForma = new FormGroup({});
  podaciIzmene!:izmenaObjaveDTO;
  mojaObjava!:Objava
  idObj!:number;

  constructor(private httpClient:HttpClient,private route: ActivatedRoute,private objavaServis : ObjaveservisService,private reakcijaServis: ReakcijaservisService,
    private ruter:Router) {
      this.mojaObjava = {
        idObjave:0,
        naslovObjave:"",
        tekstObjave:"",
        datumKreiranja:"",
        putanjaDoSlike:"",
        autorObjave:"",
        zajednica:""
        
      }
      this.podaciIzmene={
        naslovObjave:"",
        tekstObjave:""
      }
     }

  ngOnInit(): void {
    this.idObj = this.route.snapshot.params['idObjave']
    this.mojaObjava.idObjave = this.idObj
    this.nadjiObjavuPrekoId()

    this.izmeniObjavuForma = new FormGroup({
      naslovObjave: new FormControl(""),
      tekstObjave: new FormControl("")

      
      
    })
  }

  nadjiObjavuPrekoId(){
    this.objavaServis.nadjiJednuObjavu(this.idObj).subscribe(data =>{
      this.mojaObjava = data;
      console.log(data)
    })
  }

  izmeniObjavu(){
    this.podaciIzmene.naslovObjave = this.izmeniObjavuForma.get('naslovObjave')?.value
    if(this.izmeniObjavuForma.get('naslovObjave')?.value == null || this.izmeniObjavuForma.get('naslovObjave')?.value == ""){
       this.podaciIzmene.naslovObjave = this.mojaObjava.naslovObjave
    }
    this.podaciIzmene.tekstObjave = this.izmeniObjavuForma.get('tekstObjave')?.value
    if(this.izmeniObjavuForma.get('tekstObjave')?.value == null ||  this.izmeniObjavuForma.get('tekstObjave')?.value == ""){
      this.podaciIzmene.tekstObjave = this.mojaObjava.tekstObjave
    }

    this.objavaServis.izmeniObjavu(this.podaciIzmene,this.idObj).subscribe(data =>{
      console.log(data)
      this.ruter.navigate(["/homeStranica"]) 
    })

  }

}
