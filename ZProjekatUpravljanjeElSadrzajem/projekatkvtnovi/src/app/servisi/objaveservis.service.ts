import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { objavaDTO } from '../addpoststranica/addpoststranica.postDTO';
import { izmenaObjaveDTO } from '../izmenaobjave/izmenaobjave.objDTO';
import { objavaEl } from '../addpoststranica/ObjavaEl';

@Injectable({
  providedIn: 'root'
})
export class ObjaveservisService {

  constructor(private httpClient:HttpClient) {
   }

   nadjiSveObjave(){
    
   }

   dodajObjavu(objDTO:objavaDTO):Observable<any>{
    return this.httpClient.post('http://localhost:8080/posts/',objDTO)
   }

   nadjiJednuObjavu(idObj:number):Observable<any>{
    return this.httpClient.get('http://localhost:8080/posts/'+ idObj)
   }

   obrisiObjavu(idObj:number):Observable<any>{
    return this.httpClient.delete('http://localhost:8080/posts/delete/'+idObj)
   }

   izmeniObjavu(izmenaDTO: izmenaObjaveDTO,idObj:number):Observable<any>{
    return this.httpClient.put('http://localhost:8080/posts/update/' + idObj, izmenaDTO)
   }

   dodajObjavuElastik(objavaELDTO:FormData):Observable<any>{
    return this.httpClient.post('http://localhost:8080/api/objave/pdfObjave',objavaELDTO)
   }

   nadjiSveObjaveElastik():Observable<any>{
    return this.httpClient.get('http://localhost:8080/api/objave/all');
   }

   nadjiObjavePoTekstu(search_input: string):Observable<Array<objavaEl>>{
    return this.httpClient.get<any>('http://localhost:8080/api/objave/tekst/'+search_input)
   }
   
   nadjiObjavePoNaslovu(search_input:string):Observable<any>{
    return this.httpClient.get<any>('http://localhost:8080/api/objave/naslov/' + search_input)
   }

   nadjiObjavePoPdf(search_input:string):Observable<any>{
    return this.httpClient.get<any>('http://localhost:8080/api/objave/pdfTekst/'+search_input)
   }
}
