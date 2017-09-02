import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AlertComponent } from './alert.component';
import { AlertService } from './alert.service';


@NgModule({
    imports: [CommonModule, RouterModule, BrowserModule, FormsModule ],
    declarations: [AlertComponent ],
    exports: [AlertComponent],
    providers: [ AlertService]
})

export class AlertModule { }
