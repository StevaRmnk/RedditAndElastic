import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddpoststranicaComponent } from './addpoststranica/addpoststranica.component';
import { DodajzajednicustranicaComponent } from './dodajzajednicustranica/dodajzajednicustranica.component';
import { HomestranicaComponent } from './homestranica/homestranica.component';
import { IzmenaLozinkeComponent } from './izmena-lozinke/izmena-lozinke.component';
import { IzmenakorisnikaComponent } from './izmenakorisnika/izmenakorisnika.component';
import { IzmenaobjaveComponent } from './izmenaobjave/izmenaobjave.component';
import { IzmenizajednicuComponent } from './izmenizajednicu/izmenizajednicu.component';
import { JednaobjavaComponent } from './jednaobjava/jednaobjava.component';
import { JednazajednicaComponent } from './jednazajednica/jednazajednica.component';
import { LoginstranicaComponent } from './loginstranica/loginstranica.component';
import { MojprofilstranicaComponent } from './mojprofilstranica/mojprofilstranica.component';
import { ProzornapraviComponent } from './prozornapravi/prozornapravi.component';
import { RegistrstranicaComponent } from './registrstranica/registrstranica.component';
import { ZajednicastranicaComponent } from './zajednicastranica/zajednicastranica.component';
import { RezultatzajedniceComponent } from './rezultatzajednice/rezultatzajednice.component';
import { RezultatobjaveComponent } from './rezultatobjave/rezultatobjave.component';

const routes: Routes = [
  {path : 'logovanje', component: LoginstranicaComponent},
  {path : 'registracija' , component: RegistrstranicaComponent},
  {path : 'mojProfil' , component: MojprofilstranicaComponent},
  {path : 'addPost' , component: AddpoststranicaComponent},
  {path:'dodavanjeObjaveZajednice', component:ProzornapraviComponent},
  {path:'dodajZajednicu', component:DodajzajednicustranicaComponent},
  {path:'homeStranica', component:HomestranicaComponent},
  {path:'sveZajednice', component:ZajednicastranicaComponent},
  {path:'pregledJedneZajednice/:idZajednice',component:JednazajednicaComponent},
  {path:'pregledJedneObjave/:idObjave',component:JednaobjavaComponent},
  {path:'izmenaZajednice/:idZajednice', component:IzmenizajednicuComponent},
  {path: "izmenaObjave/:idObjave", component:IzmenaobjaveComponent},
  {path:"izmenaProfila", component:IzmenakorisnikaComponent},
  {path:"izmeniLozinku", component:IzmenaLozinkeComponent},
  {path:"rezultatZajednice",component:RezultatzajedniceComponent},
  {path:"rezultatObjave",component:RezultatobjaveComponent}

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
