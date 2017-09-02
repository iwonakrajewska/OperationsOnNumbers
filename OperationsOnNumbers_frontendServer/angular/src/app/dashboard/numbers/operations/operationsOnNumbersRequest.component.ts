import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router, ActivatedRoute } from '@angular/router';

import { Lookup } from '../../../shared/lookup/lookup';
import { TwoNumbersRequest } from './twoNumbersRequest';
import { NumbersResultDisplay } from './numbersResultDisplay';
import { LookupService } from '../../../shared/lookup/lookup.service';
import { NumbersService } from '../numbers.service'
import { AlertService } from '../../../shared/alert/alert.service'





@Component({

  selector: 'numbers-search-request',
  templateUrl: './numbers-request.component.html'
})

export class OperationsOnNumbersRequestComponent implements OnInit {

  model: TwoNumbersRequest;
  massUpdateTypeOptions: Lookup[];
  massUpdateRequestStatusOptions: Lookup[];
  resultList: NumbersResultDisplay[];


  constructor(private _lookupService: LookupService,
    private _numbersService: NumbersService,
    private alertService: AlertService) {
  }

  ngOnInit() {
    this.model = new TwoNumbersRequest();
    this.defaultForm();
  }

  defaultForm() {
    this.resultList = null;
    this.model.numberText1 = '10';
    this.model.numberText2 = '2.5';
  }


  invokeException() {
    this.alertService.clear();
    this.resultList = null;

    this._numbersService.callExceptionRequest(this.model).subscribe(
      responseBody => {
        if (responseBody.infoMessage) {
          this.alertService.success(responseBody.infoMessage);
        }
        if (responseBody.errorMessages) {
          this.alertService.errorList(responseBody.errorMessages);
        }
        if (responseBody.errorMessages.length == 0) {
          this.resultList = this.mapResponseToDisplay(this.model, 'Addition', responseBody.numberText);
        }
      },
      error => {
        this.alertService.error('Problem searching for results. ' + error);
      }
    );

  }


  invokeInvalidUrl() {
    this.alertService.clear();
    this.resultList = null;

    this._numbersService.callInvalidServerRequest(this.model).subscribe(
      responseBody => {
        if (responseBody.infoMessage) {
          this.alertService.success(responseBody.infoMessage);
        }
        if (responseBody.errorMessages) {
          this.alertService.errorList(responseBody.errorMessages);
        }
        if (responseBody.errorMessages.length == 0) {
          this.resultList = this.mapResponseToDisplay(this.model, 'Addition', responseBody.numberText);
        }
      },
      error => {
        this.alertService.error('Problem searching for results. ' + error);
      }
    );

  }


  subtract() {
    this.alertService.clear();
    this.resultList = null;

    this._numbersService.subtractionRequest(this.model).subscribe(
      responseBody => {
        if (responseBody.infoMessage) {
          this.alertService.success(responseBody.infoMessage);
        }
        if (responseBody.errorMessages) {
          this.alertService.errorList(responseBody.errorMessages);
        }
        if (responseBody.errorMessages.length == 0) {
          this.resultList = this.mapResponseToDisplay(this.model, 'Subtraction', responseBody.numberText);
        }
      },
      error => {
        this.alertService.error('Problem searching for results. ' + error);
      }
    );
  }

  multiply() {
    this.alertService.clear();
    this.resultList = null;

    this._numbersService.multiplicationRequest(this.model).subscribe(
      responseBody => {
        if (responseBody.infoMessage) {
          this.alertService.success(responseBody.infoMessage);
        }
        if (responseBody.errorMessages) {
          this.alertService.errorList(responseBody.errorMessages);
        }
        if (responseBody.errorMessages.length == 0) {
          this.resultList = this.mapResponseToDisplay(this.model, 'Multiplication', responseBody.numberText);
        }
      },
      error => {
        this.alertService.error('Problem searching for results. ' + error);
      }
    );
  }

  divide() {
    this.alertService.clear();
    this.resultList = null;

    this._numbersService.divisionRequest(this.model).subscribe(
      responseBody => {
        if (responseBody.infoMessage) {
          this.alertService.success(responseBody.infoMessage);
        }
        if (responseBody.errorMessages) {
          this.alertService.errorList(responseBody.errorMessages);
        }
        if (responseBody.errorMessages.length == 0) {
          this.resultList = this.mapResponseToDisplay(this.model, 'Division', responseBody.numberText);
        }
      },
      error => {
        this.alertService.error('Problem searching for results. ' + error);
      }
    );
  }

  add() {
    this.alertService.clear();
    this.resultList = null;

    this._numbersService.additionRequest(this.model).subscribe(
      responseBody => {
        if (responseBody.infoMessage) {
          this.alertService.success(responseBody.infoMessage);
        }
        if (responseBody.errorMessages) {
          this.alertService.errorList(responseBody.errorMessages);
        }
        if (responseBody.errorMessages.length == 0) {
          this.resultList = this.mapResponseToDisplay(this.model, 'Addition', responseBody.numberText);
        }
      },
      error => {
        this.alertService.error('Problem searching for results. ' + error);
      }
    );
  }

  private mapResponseToDisplay(screenInput: TwoNumbersRequest, operationName: string, responseSingleText: string): NumbersResultDisplay[] {
    let numbersResultDisplay = new NumbersResultDisplay();
    numbersResultDisplay.numberText1 = screenInput.numberText1;
    numbersResultDisplay.numberText2 = screenInput.numberText2;
    numbersResultDisplay.operation = operationName;
    numbersResultDisplay.result = responseSingleText;

    let displayArray: NumbersResultDisplay[] = [
      numbersResultDisplay
    ];

    return displayArray;
  }
}

