import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { authService } from '../servisi/auth.service';

@Component({
  selector: 'app-loginstranica',
  templateUrl: './loginstranica.component.html',
  styleUrls: ['./loginstranica.component.css']
})
export class LoginstranicaComponent implements OnInit {

  loginForma = new FormGroup({});
  username!: string;

  constructor(private httpClient:HttpClient,private ruter:Router,private authService:authService) { }

  ngOnInit(): void {
    this.loginForma = new FormGroup({
      username: new FormControl("", Validators.required),
      password: new FormControl("", Validators.required)
    })
  }

  ulogujSE(){
    this.authService.login(this.loginForma.value).subscribe(data=>{
      this.ruter.navigateByUrl("/homeStranica")
    })
  }

}
