import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';

export const routes: Routes = [

    { path: '', redirectTo: 'dashboard', pathMatch: 'full' }
    , {
        path: 'login',
        component: LoginComponent
    }
    , {
        path: "registration",
        component: RegisterComponent
    }, {
        path: "dashboard",
        component: DashboardComponent
    }
];
