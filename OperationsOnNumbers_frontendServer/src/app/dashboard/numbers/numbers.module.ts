import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormControl, FormGroup } from '@angular/forms';
import { LookupService } from '../../shared/lookup/lookup.service'; 
import { NumbersService } from './numbers.service';  
import { Config } from '../../shared/properties/config';
import { UtilService } from '../../shared/utils/util.service';
import { RouterModule, Routes } from '@angular/router';





import { OperationsOnNumbersRequestComponent } from './operations/operationsOnNumbersRequest.component';
import { OperationsOnNumbersResultListComponent } from './operations/operationsOnNumbersResultList.component';

  
@NgModule({
  imports: [    BrowserModule, FormsModule, ReactiveFormsModule, RouterModule],
  declarations: [ OperationsOnNumbersRequestComponent,OperationsOnNumbersResultListComponent],
  exports: [ OperationsOnNumbersRequestComponent,OperationsOnNumbersResultListComponent],
  providers: [LookupService, NumbersService, Config, UtilService], 
})

export class NumbersModule { }




