import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { Korisnik } from '../kartica-objave/kartica-objave.component';
import { authService } from '../servisi/auth.service';
import { KorisnikServisService } from '../servisi/korisnik-servis.service';
import { izmenalozinkeDto } from './izmenalozinkeDTO';

@Component({
  selector: 'app-izmena-lozinke',
  templateUrl: './izmena-lozinke.component.html',
  styleUrls: ['./izmena-lozinke.component.css']
})
export class IzmenaLozinkeComponent implements OnInit {

  izmeniLozinkuForma = new FormGroup({})
  korisnickoIme!:string;
  korisnik!:Korisnik
  podaciIzmene!: izmenalozinkeDto



  constructor(private korisnikServis:KorisnikServisService,private authServis: authService, private formBilder: FormBuilder) {
    this.podaciIzmene = {
      korisnickoIme:"",
      staraLozinka:"",
      lozinka:"",
      ponovljenaLozinka:""
    }
   }

  ngOnInit(): void {

    this.korisnickoIme = this.authServis.nadjiKorisnickoIme()
    this.nadjiKorisnikaSaLozinkom()

    this.izmeniLozinkuForma = new FormGroup({
      staraLozinka:new FormControl("",Validators.required),
      novaLozinka:new FormControl("",Validators.required),
      ponovljenaLozinka:new FormControl("",[Validators.required])

    })
    
      // this.staraLozinka = new FormControl("",[Validators.required]),
      // this.novaLozinka = new FormControl("", Validators.required),
      // this.ponovljenaLozinka = new FormControl("", [Validators.required,this.PoklapaSe(this.novaLozinka)])

      // this.izmeniLozinkuForma = this.formBilder.group({
      //   staralozinka : this.staraLozinka,
      //   novalozinka: this.novaLozinka,
      //   ponovljenaLozinka: this.ponovljenaLozinka
      // })
      
  }
  

//   PoklapaSe(firstControl: AbstractControl): ValidatorFn {
//     return (
//         secondControl: AbstractControl
//     ): { [key: string]: boolean } | null => {
//         if (!firstControl && !secondControl) {
//             return null;
//         }

//         if (secondControl.hasError && !firstControl.hasError) {
//             return null;
//         }
//         if (firstControl.value !== secondControl.value) {
//             return { mustMatch: true };
//         } else {
//             return null;
//         }
//     };
// }

  

  nadjiKorisnikaSaLozinkom(){
    this.korisnikServis.nadjiKorisnikaSaLozinkom(this.korisnickoIme).subscribe(data=>{
      console.log(data)
      this.korisnik = data;
    })

  }

  izmeniLozinku(){

    if (this.izmeniLozinkuForma.valid && (this.izmeniLozinkuForma.get('staraLozinka')?.value != this.izmeniLozinkuForma.get('ponovljenaLozinka')?.value) ) {
      this.podaciIzmene.korisnickoIme = this.korisnickoIme;
      this.podaciIzmene.staraLozinka = this.izmeniLozinkuForma.get('staraLozinka')?.value
      this.podaciIzmene.lozinka = this.izmeniLozinkuForma.get('novaLozinka')?.value;
      this.podaciIzmene.ponovljenaLozinka = this.izmeniLozinkuForma.get('ponovljenaLozinka')?.value

      this.korisnikServis.izmeniLozinku(this.podaciIzmene).subscribe(data=>{
        console.log(data)

      })
  }else if(this.izmeniLozinkuForma.get('novaLozinka')?.value != this.izmeniLozinkuForma.get('ponovljenaLozinka')){
    alert("Nova lozinka i ponovljena nisu iste!")
  }
  else{
    alert("Nova lozinka ne sme biti ista staroj lozinki!");
  }


  }

}
