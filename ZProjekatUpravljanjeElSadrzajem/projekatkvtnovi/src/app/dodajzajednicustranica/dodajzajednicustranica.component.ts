import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { authService } from '../servisi/auth.service';
import { ZajedniceservisService } from '../servisi/zajedniceservis.service';
import { ZahtevZajednice } from './dodajzajednicustranica.zahtevzajednice';

@Component({
  selector: 'app-dodajzajednicustranica',
  templateUrl: './dodajzajednicustranica.component.html',
  styleUrls: ['./dodajzajednicustranica.component.css']
})
export class DodajzajednicustranicaComponent implements OnInit {


  napraviZajednicuForma = new FormGroup({});
  zahtevZajednice!:ZahtevZajednice;
  constructor(private zajedniceServis:ZajedniceservisService, private ruter: Router,private authServis:authService) {
    this.zahtevZajednice = {
      imeZajednice:"",
      opisZajednice:""
    }
   }

  ngOnInit() {
    this.napraviZajednicuForma = new FormGroup({
      imeZajednice:new FormControl("",[Validators.required,Validators.minLength(3)]),
      opisZajednice:new FormControl("",Validators.required)
    })
  }

  napraviZajednicu(){
    let uploadModel: FormData = new FormData();

    if(this.authServis.tokenPostoji()){
      this.zahtevZajednice.imeZajednice = this.napraviZajednicuForma.get("imeZajednice")?.value;
    this.zahtevZajednice.opisZajednice = this.napraviZajednicuForma.get("opisZajednice")?.value;

    if(this.event != undefined){
      const file:File = this.event.target.files[0];
      uploadModel.append("imeZajednice",this.napraviZajednicuForma.get("imeZajednice")?.value)
      uploadModel.append("opisZajednice",this.napraviZajednicuForma.get("opisZajednice")?.value) 
      uploadModel.append("fajlovi",file)

      this.zajedniceServis.dodajZajednicuElastik(uploadModel).subscribe(data =>{
        console.log(data)
        this.ruter.navigate(["/homeStranica"]) 
      }, error =>{
        console.log(error)
        this.ruter.navigate(["/homeStranica"]) 
      })
    }
    else{
      uploadModel.append("imeZajednice",this.napraviZajednicuForma.get("imeZajednice")?.value)
      uploadModel.append("opisZajednice",this.napraviZajednicuForma.get("opisZajednice")?.value)
      this.zajedniceServis.dodajZajednicuElastik(uploadModel).subscribe(data =>{
        console.log(data)
        this.ruter.navigate(["/homeStranica"]) 
      }, error =>{
        console.log(error)
        this.ruter.navigate(["/homeStranica"]) 
      })
    }

    this.zajedniceServis.napraviZajednicu(this.zahtevZajednice).subscribe(data =>{
      console.log(data)
      this.ruter.navigate(["/homeStranica"]) 
    })
  }
  else{
    alert("Morate se ulogovati da bi vam bila dostupna ova opcija!")
  }
    }
    
    setEvent(event: any) {
      this.event = event;
      console.log(this.event)
    }
  
    
    event: any;

}
