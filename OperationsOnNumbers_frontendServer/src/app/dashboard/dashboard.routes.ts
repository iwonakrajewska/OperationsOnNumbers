import { Route } from '@angular/router';

import { HomeRoutes } from './home/home.routes';
import { NumbersRoutes } from './numbers/numbers.routes'; 

import { DashboardComponent } from './index';
import { AuthorizationGuard } from '../login/authorization.guard'; 

export const DashboardRoutes: Route[] = [
    {
      path: 'dashboard',
      component: DashboardComponent,
      children: [
        ...NumbersRoutes,
        ...HomeRoutes
      ],
      canActivate: [AuthorizationGuard] 
    }
    
];
