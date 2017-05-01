import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login.component';
import { LoginService } from './login.service';
import { AlertModule } from '../shared/alert/alert.module'; 


@NgModule({
    imports: [CommonModule, RouterModule, BrowserModule, FormsModule , AlertModule],
    declarations: [LoginComponent ],
    exports: [LoginComponent],
    providers: [LoginService]
})

export class LoginModule { }
