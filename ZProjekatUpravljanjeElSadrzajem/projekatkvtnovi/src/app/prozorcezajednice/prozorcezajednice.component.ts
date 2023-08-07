import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Zajednica } from '../kartica-objave/kartica-objave.component';
import { ZajedniceservisService } from '../servisi/zajedniceservis.service';


@Component({
  selector: 'app-prozorcezajednice',
  templateUrl: './prozorcezajednice.component.html',
  styleUrls: ['./prozorcezajednice.component.css']
})
export class ProzorcezajedniceComponent implements OnInit {

  zajednice!: Zajednica[];
  prikaziSve!: boolean

  constructor(private zajednicaService: ZajedniceservisService) { 
    this.zajednicaService.nadjiZajednice().subscribe(data =>{
      if(data.length > 3){
        this.zajednice = data.splice(0,3);
        this.prikaziSve = true;
      }else{
        this.zajednice = data;
      }
    })
  }

  ngOnInit() {
  }

  

}
