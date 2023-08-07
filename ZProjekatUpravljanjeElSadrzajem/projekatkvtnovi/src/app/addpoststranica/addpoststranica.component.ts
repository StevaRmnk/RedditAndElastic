import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, RouteReuseStrategy } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { Zajednica } from '../kartica-objave/kartica-objave.component';
import { authService } from '../servisi/auth.service';
import { ObjaveservisService } from '../servisi/objaveservis.service';
import { ZajedniceservisService } from '../servisi/zajedniceservis.service';
import { objavaDTO } from './addpoststranica.postDTO';



@Component({
  selector: 'app-addpoststranica',
  templateUrl: './addpoststranica.component.html',
  styleUrls: ['./addpoststranica.component.css']
})
export class AddpoststranicaComponent implements OnInit {

  mojeZajednice:Zajednica[] = []
  dodajObjavuForma: FormGroup = new FormGroup({})
  objDTO!: objavaDTO;
  event:any;


  constructor(private objaveservisService: ObjaveservisService,public zajednicaServis: ZajedniceservisService,private ruter: Router,private authServis:authService) {
    this.objDTO ={
      naslovObjave:"",
      tekstObjave:"",
      putanjaDoSlike:"",
      autorObjave:"",
      zajednica:0

    }

    this.zajednicaServis.nadjiZajednice().subscribe(data =>{
      console.log(data)
      this.mojeZajednice = data
    })
   }

  ngOnInit() {

    this.dodajObjavuForma = new FormGroup({
      naslovObjave: new FormControl("",Validators.required),
      tekstObjave: new FormControl("",Validators.required),
      zajednica: new FormControl("",Validators.required)

      
      
    })
  
  }




  napraviObjavu(){
    let uploadModel: FormData = new FormData();


    if(this.authServis.tokenPostoji()){
      this.objDTO.naslovObjave = this.dodajObjavuForma.get('naslovObjave')?.value,
      this.objDTO.tekstObjave = this.dodajObjavuForma.get('tekstObjave')?.value,
      this.objDTO.putanjaDoSlike = "",
      this.objDTO.autorObjave = this.authServis.nadjiKorisnickoIme()
      this.objDTO.zajednica = this.dodajObjavuForma.get('zajednica')?.value

      if(this.event != undefined){
        const file: File = this.event.target.files[0];
        uploadModel.append("naslovObjave",this.dodajObjavuForma.get('naslovObjave')?.value)
        uploadModel.append("tekstObjave",this.dodajObjavuForma.get('tekstObjave')?.value)
        uploadModel.append("fajlovi",file)
        
        this.objaveservisService.dodajObjavuElastik(uploadModel).subscribe(data =>{
          console.log(data)
          this.ruter.navigateByUrl('/homeStranica');
        }, error =>{
          console.log(error)
          this.ruter.navigateByUrl('/homeStranica')
        })
        
      }else{
        uploadModel.append("naslovObjave",this.dodajObjavuForma.get('naslovObjave')?.value)
        uploadModel.append("tekstObjave",this.dodajObjavuForma.get('tekstObjave')?.value)
        this.objaveservisService.dodajObjavuElastik(uploadModel).subscribe(data =>{
          console.log(data)
          this.ruter.navigateByUrl('/homeStranica');
        }, error =>{
          console.log(error)
          this.ruter.navigateByUrl('/homeStranica')
        })
      }
  
      this.objaveservisService.dodajObjavu(this.objDTO).subscribe(data => {
        console.log(data)
        this.ruter.navigateByUrl('/homeStranica');
      }, error =>{
        console.log(error)
        this.ruter.navigateByUrl('/homeStranica')
      })
    
    }
    else{
      alert("Morate se ulogovati da bi vam bila dostupna ova opcija!")
    }
    }

    setEvent(event: any){
      this.event = event;
      console.log(this.event)
    }
   

}
