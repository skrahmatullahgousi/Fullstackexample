import { Component, inject } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { RouterOutlet,Router } from '@angular/router';
@Component({
  selector: 'app-root',
  standalone: true,  // ✅ Added for standalone components
  imports: [
   
  RouterOutlet,FormsModule,CommonModule,RouterModule
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Quiz';

  question = {
    id: 1,
    text: '',
    answers: [],
  };

  isSidebarOpen = false;
router=inject(Router);
 
  logoff() {
    console.log('User logged off');
    this.router.navigateByUrl('login')
  }
}
