import { Component, OnInit } from '@angular/core';
import { PretragaService } from '../servisi/pretraga.service';
import { ActivatedRoute } from '@angular/router';
import { ObjaveservisService } from '../servisi/objaveservis.service';
import { objavaELDTO } from './objavaELDTO';

@Component({
  selector: 'app-rezultatobjave',
  templateUrl: './rezultatobjave.component.html',
  styleUrls: ['./rezultatobjave.component.css']
})
export class RezultatobjaveComponent implements OnInit {

  pojam!:string;
  odabir!:string;
  objave!:objavaELDTO[]

  constructor(private pretragaServis:PretragaService,private route: ActivatedRoute,private objavaServis:ObjaveservisService) { }

  ngOnInit(): void {
    this.pojam = this.pretragaServis.pojam


    this.odabir = this.pretragaServis.odabir

    console.log(this.pojam)
    console.log(this.odabir)

    if(this.odabir == 'naslov'){
      this.nadjiObjavePoNaslovu()
    }
    else if(this.odabir == 'tekst'){
      this.nadjiObjavePoTekstu()
    }
    else{
      this.nadjiObjavePoPdfu()
    }
  }

  nadjiObjavePoNaslovu(){
    this.objavaServis.nadjiObjavePoNaslovu(this.pojam).subscribe(data =>{
      this.objave = data
      console.log(data)
  })
  }

  nadjiObjavePoTekstu(){
    this.objavaServis.nadjiObjavePoTekstu(this.pojam).subscribe(data =>{
      this.objave = data
      console.log(data)
  })
  }

  nadjiObjavePoPdfu(){
    this.objavaServis.nadjiObjavePoPdf(this.pojam).subscribe(data =>{
      this.objave = data
      console.log(data)
  })
  }


}
