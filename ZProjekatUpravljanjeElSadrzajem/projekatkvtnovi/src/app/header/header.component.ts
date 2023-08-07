import { Component, OnInit } from '@angular/core';
import { authService } from '../servisi/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: authService) { }

  ngOnInit(): void {

  }

  logout(){
    this.authService.logout();
  }

  ulogovan(){
    return this.authService.tokenPostoji()

  }
}
