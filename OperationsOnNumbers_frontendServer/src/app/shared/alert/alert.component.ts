import { Component, OnInit } from '@angular/core';
 
import { AlertService } from './alert.service';
 
@Component({

    selector: 'alert',
    templateUrl: 'alert.component.html'
})
 
export class AlertComponent {
    message: any;
    messageList: string[];
    typeList: string;
 
    constructor(private alertService: AlertService) { }
 
    ngOnInit() {
        this.alertService.getMessage().subscribe(message => { this.message = message; });
        this.alertService.getMessageList().subscribe(result => {
            this.messageList = result.textList; 
            this.typeList = result.typeList;
        });
    }
}