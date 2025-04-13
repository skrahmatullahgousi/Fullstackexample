import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { LoginComponent } from '../pages/login/login.component';

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrls:[ './dashboard.component.css']
})
export class DashboardComponent {
  isSidebarOpen = false;
  
}
