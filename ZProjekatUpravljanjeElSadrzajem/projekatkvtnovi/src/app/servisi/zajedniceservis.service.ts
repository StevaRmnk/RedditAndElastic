import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ZahtevZajednice } from '../dodajzajednicustranica/dodajzajednicustranica.zahtevzajednice';
import { ZajednicaEl } from '../dodajzajednicustranica/ZajednicaEl';



@Injectable({
  providedIn: 'root'
})
export class ZajedniceservisService {

  constructor(private httpClient:HttpClient) { 
  }

  napraviZajednicu(zahtevZajednice: ZahtevZajednice):Observable<any>{
    return this.httpClient.post("http://localhost:8080/communities/",zahtevZajednice);
  }

  nadjiZajednice(){
    return this.httpClient.get<any>("http://localhost:8080/communities/")
  }

  nadjiZajednicu(idZaj: number): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8080/communities/'+idZaj );
  }

  nadjiObjaveZajednice(idZaj:number): Observable<any>{
    return this.httpClient.get<any>('http://localhost:8080/posts/idZajednice/'+ idZaj) 
  };
  izmeniZajednicu(podaciIzmene:ZahtevZajednice,idZaj:number):Observable<any>{
    return this.httpClient.put("http://localhost:8080/communities/update/" + idZaj, podaciIzmene)
  }

  dodajZajednicuElastik(uploadModel:FormData):Observable<any>{
    return this.httpClient.post("http://localhost:8080/api/zajednice/pdf",uploadModel)
  }

  nadjiSveZajednice():Observable<any>{
    return this.httpClient.get("http://localhost:8080/api/zajednice/all")
  }

  nadjiZajednicePoNazivu(search_input:string):Observable<any>{
    return this.httpClient.get<any>("http://localhost:8080/api/zajednice/naziv/"+search_input)
  }

  nadjiZajednicePoOpisu(search_input:string):Observable<Array<ZajednicaEl>>{
    return this.httpClient.get<Array<ZajednicaEl>>("http://localhost:8080/api/zajednice/opis/"+search_input)
  }

  nadjiZajednicePoPdf(search_input:string):Observable<Array<ZajednicaEl>>{
    return this.httpClient.get<Array<ZajednicaEl>>("http://localhost:8080/api/zajednice/pdfOpis/" +search_input)
  }
  
}
