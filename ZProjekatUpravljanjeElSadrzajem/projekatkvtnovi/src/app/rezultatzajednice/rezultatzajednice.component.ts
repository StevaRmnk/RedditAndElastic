import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { zajednicaELDTO } from './zajednicaELDTO';
import { ZajedniceservisService } from '../servisi/zajedniceservis.service';
import { PretragaService } from '../servisi/pretraga.service';

@Component({
  selector: 'app-rezultatzajednice',
  templateUrl: './rezultatzajednice.component.html',
  styleUrls: ['./rezultatzajednice.component.css']
})
export class RezultatzajedniceComponent implements OnInit {

  pojam!:string;
  odabir!:string;
  zajednice!:zajednicaELDTO[]
  receivedValues: any;
  bla:any;
  

  constructor(private route: ActivatedRoute,private zajedniceServis:ZajedniceservisService,private pretragaServis:PretragaService) {
  }

  ngOnInit(): void {
    this.pojam = this.pretragaServis.pojam


    this.odabir = this.pretragaServis.odabir

    console.log(this.pojam)
    console.log(this.odabir)

   
    if(this.odabir == 'naziv'){
      this.nadjiZajedicePoNazivu()
    }
    else if(this.odabir == 'opis'){
      this.nadjiZajednicePoOpisu()
    }
    else{
      this.nadjiZajednicePoPDFU()
    }

  }
  
  nadjiZajedicePoNazivu(){
    this.zajedniceServis.nadjiZajednicePoNazivu(this.pojam).subscribe(data =>{
        this.zajednice = data
        console.log(data)
    })
  }

  nadjiZajednicePoOpisu(){
    this.zajedniceServis.nadjiZajednicePoOpisu(this.pojam).subscribe(data =>{
      this.zajednice = data
      console.log(data)
  })
  }

  nadjiZajednicePoPDFU(){
    this.zajedniceServis.nadjiZajednicePoPdf(this.pojam).subscribe(data =>{
      this.zajednice = data
      console.log(data)
  })
  }
  


}
