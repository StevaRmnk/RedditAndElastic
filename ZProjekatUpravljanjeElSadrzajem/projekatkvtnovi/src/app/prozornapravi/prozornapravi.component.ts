import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { authService } from '../servisi/auth.service';

@Component({
  selector: 'app-prozornapravi',
  templateUrl: './prozornapravi.component.html',
  styleUrls: ['./prozornapravi.component.css']
})
export class ProzornapraviComponent implements OnInit {

  constructor(private route: Router, private authServis:authService) { }


  ngOnInit(): void {
  }

  dodajObjavu(){
    if(this.authServis.tokenPostoji()){
      this.route.navigateByUrl("/addPost")
    }
    else(
      alert("Morate se ulogovati da bi vam bila dostupna ova opcija!")
    )
  }

  dodajZajednicu(){
    if(this.authServis.tokenPostoji()){
      this.route.navigateByUrl("/dodajZajednicu")
    }
    else(
      alert("Morate se ulogovati da bi vam bila dostupna ova opcija!")
    )
  }

}
