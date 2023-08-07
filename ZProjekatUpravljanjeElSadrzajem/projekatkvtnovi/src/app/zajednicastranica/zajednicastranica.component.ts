import { Component, OnInit } from '@angular/core';
import { Zajednica } from '../kartica-objave/kartica-objave.component';
import { ZajedniceservisService } from '../servisi/zajedniceservis.service';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { state } from '@angular/animations';
import { PretragaService } from '../servisi/pretraga.service';

@Component({
  selector: 'app-zajednicastranica',
  templateUrl: './zajednicastranica.component.html',
  styleUrls: ['./zajednicastranica.component.css']
})
export class ZajednicastranicaComponent implements OnInit {

  zajednice!: Zajednica[]
  pretraziForma: FormGroup = new FormGroup({})

  formValues = {
    pojam: '',
    odabir: ''
  };
  

  constructor(private zajednicaServis: ZajedniceservisService,private router: Router,private pretragaServis:PretragaService) { 
    
  }

  ngOnInit(): void {

    this.pretraziForma = new FormGroup({
      pojam: new FormControl("",Validators.required),
      odabir: new FormControl("",Validators.required)

      
      
    })

    this.zajednicaServis.nadjiZajednice().subscribe(content =>
      {
        console.log(content)
        this.zajednice = content
      })
  }

  pretrazi(){
    
    const pojam =  this.pretraziForma.get('pojam')?.value;

    const odabir = this.pretraziForma.get('odabir')?.value

    this.pretragaServis.setOdabir(odabir)

    this.pretragaServis.setPojam(pojam)


    this.router.navigate(['/rezultatZajednice']);
  }

}
