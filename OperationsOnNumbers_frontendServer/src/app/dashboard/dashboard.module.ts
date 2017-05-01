import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { DropdownModule } from 'ng2-bootstrap/ng2-bootstrap';

import { HomeModule } from './home/home.module';
import { NumbersModule } from './numbers/numbers.module';

import { DashboardComponent } from './dashboard.component';

import { TopNavComponent } from '../shared/index';
import { SidebarComponent } from '../shared/index';

import { AlertModule } from '../shared/alert/alert.module';




@NgModule({
  imports: [
    NumbersModule,
    CommonModule,
    RouterModule,
    DropdownModule,
    HomeModule,
    AlertModule,
    RouterModule
  ],
  declarations: [DashboardComponent, TopNavComponent, SidebarComponent],
  exports: [DashboardComponent, TopNavComponent, SidebarComponent, RouterModule]
})

export class DashboardModule { }
