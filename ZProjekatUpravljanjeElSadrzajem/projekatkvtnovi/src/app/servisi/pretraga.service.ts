import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PretragaService {

  pojam!:string;
  odabir!:string;

  constructor() { }

  setPojam(search_pojam:string){
    this.pojam = search_pojam
  }

  setOdabir(search_odabir:string){
    this.odabir = search_odabir
  }
}
