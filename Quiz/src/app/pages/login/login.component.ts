import { Component } from '@angular/core';
import { HttpClient, } from '@angular/common/http';
import { inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule ,HttpClientModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  api = inject(HttpClient);
  baseurl = "http://localhost:8080";
  login = {
    email: '',
    registerPassword: ''
  }
  // getquestionsdata() {
  //   this.api.get<any>(`${this.baseurl}/login`).subscribe((data) => {
  //     console.log(data);
  //   }, (error) => {

  //     console.log(error);
  //   }
  //   )
  // }
  Logindetails() {
    this.api.post<any>(`${this.baseurl}/login`, this.login).subscribe((data) => {
      console.log(data)
    }, (error) => {
      console.log(error);
    })
  }
  logind(){
    alert('your login is sucessful');
  }
}
