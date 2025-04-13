import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { FormsModule } from '@angular/forms';  // Import FormsModule
@Component({
  selector: 'app-register',
  imports: [FormsModule,],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  Register = {
    registerName: '',
    registerpassword: '',
    email: ''
  }
  api = inject(HttpClient);
  baseurl = "http://localhost:8080";
  Registerdetails() {
    this.api.post<any>(`${this.baseurl}/register`, this.Register).subscribe((data) => {
      console.log(data);
    }, (error) => {

      console.log(error);
    }
    )
  }
}
