import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Objava } from '../kartica-objave/kartica-objave.component';
import { authService } from '../servisi/auth.service';
import { ObjaveservisService } from '../servisi/objaveservis.service';
import { ReakcijaservisService } from '../servisi/reakcijaservis.service';
import { Reakcija } from './Reakcija';
import { TipReakcije } from './tipReakcije';

@Component({
  selector: 'app-dugmereakcije',
  templateUrl: './dugmereakcije.component.html',
  styleUrls: ['./dugmereakcije.component.css']
})
export class DugmereakcijeComponent implements OnInit {

  @Input() jednaobjava!: Objava;
  reakcija!:Reakcija;
  karma!:number;
 

  constructor(private objavaServis:ObjaveservisService,private reakcijaServis: ReakcijaservisService,private route: ActivatedRoute,private ruter: Router,private authServis:authService) { 
    this.reakcija = {
      autorReakcije:"",
      idObjave : 1,
      tipReakcije: TipReakcije.UPVOTE

    }
  }


  ngOnInit(): void {
     this.nadjiObjavu()
     this.izracunajKarmu()
  }

  upvotuj(){
    if(this.authServis.tokenPostoji()){
      this.reakcija.tipReakcije = TipReakcije.UPVOTE
    this.napraviReakciju()
    }
    else{
      alert("Morate se ulogovati da bi vam bila dostupna opcija glasanja!")
    }
    
  }

  downvotuj(){
    if(this.authServis.tokenPostoji()){
      this.reakcija.tipReakcije = TipReakcije.DOWNVOTE
    this.napraviReakciju();
    }
    else{
      alert("Morate se ulogovati da bi vam bila dostupna opcija glasanja!")
    }
    
  }

  private napraviReakciju(){
 
    this.reakcija.idObjave = this.jednaobjava.idObjave;
    console.log(this.reakcija.idObjave)
    this.reakcija.autorReakcije = this.authServis.nadjiKorisnickoIme()
    this.reakcijaServis.napraviReakciju(this.reakcija).subscribe( ()=>{
      this.nadjiObjavu
      this.izracunajKarmu()
      this.ruter.navigateByUrl("/homeStranica")
    }, error =>{
      location.reload();
    })
  } 

  izracunajKarmu(){
    this.reakcijaServis.nadjiKarmuObjave(this.jednaobjava.idObjave).subscribe(data=>{
      console.log(data)
      this.karma = data
    })
  }


  private nadjiObjavu(){
    this.objavaServis.nadjiJednuObjavu(this.jednaobjava.idObjave).subscribe(jednaobjava=>{
      this.jednaobjava = jednaobjava;
      console.log(jednaobjava)
    })
  }
}  
 