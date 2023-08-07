import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginstranicaComponent } from './loginstranica/loginstranica.component';
import { RegistrstranicaComponent } from './registrstranica/registrstranica.component';
import { AddpoststranicaComponent } from './addpoststranica/addpoststranica.component';
import { MojprofilstranicaComponent } from './mojprofilstranica/mojprofilstranica.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { KarticaObjaveComponent } from './kartica-objave/kartica-objave.component';
import { ProzornapraviComponent } from './prozornapravi/prozornapravi.component';
import { DugmereakcijeComponent } from './dugmereakcije/dugmereakcije.component';
import { ProzorcezajedniceComponent } from './prozorcezajednice/prozorcezajednice.component';
import { DodajzajednicustranicaComponent } from './dodajzajednicustranica/dodajzajednicustranica.component';
import { HomestranicaComponent } from './homestranica/homestranica.component';
import { JednazajednicaComponent } from './jednazajednica/jednazajednica.component';
import { ZajednicastranicaComponent } from './zajednicastranica/zajednicastranica.component';
import { JednaobjavaComponent } from './jednaobjava/jednaobjava.component';
import { IzmenizajednicuComponent } from './izmenizajednicu/izmenizajednicu.component';
import { IzmenaobjaveComponent } from './izmenaobjave/izmenaobjave.component';
import { IzmenakorisnikaComponent } from './izmenakorisnika/izmenakorisnika.component';
import { IzmenaLozinkeComponent } from './izmena-lozinke/izmena-lozinke.component';
import { RezultatzajedniceComponent } from './rezultatzajednice/rezultatzajednice.component';
import { RezultatobjaveComponent } from './rezultatobjave/rezultatobjave.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginstranicaComponent,
    RegistrstranicaComponent,
    AddpoststranicaComponent,
    MojprofilstranicaComponent,
    KarticaObjaveComponent,
    ProzornapraviComponent,
    DugmereakcijeComponent,
    ProzorcezajedniceComponent,
    DodajzajednicustranicaComponent,
    HomestranicaComponent,
    ZajednicastranicaComponent,
    JednazajednicaComponent,
    JednaobjavaComponent,
    IzmenizajednicuComponent,
    IzmenaobjaveComponent,
    IzmenakorisnikaComponent,
    IzmenaLozinkeComponent,
    RezultatzajedniceComponent,
    RezultatobjaveComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
