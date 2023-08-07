import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PretragaService } from '../servisi/pretraga.service';

@Component({
  selector: 'app-homestranica',
  templateUrl: './homestranica.component.html',
  styleUrls: ['./homestranica.component.css']
})
export class HomestranicaComponent implements OnInit {

  pretraziForma: FormGroup = new FormGroup({})

  
  constructor(private router: Router,private pretragaServis: PretragaService) { }

  ngOnInit(): void {

    this.pretraziForma = new FormGroup({
      pojam: new FormControl("",Validators.required),
      odabir: new FormControl("",Validators.required)

      
      
    })
  }


  pretrazi(){
    
    const pojam =  this.pretraziForma.get('pojam')?.value;

    const odabir = this.pretraziForma.get('odabir')?.value

    this.pretragaServis.setOdabir(odabir)

    this.pretragaServis.setPojam(pojam)


    this.router.navigate(['/rezultatObjave']);
  }

}
