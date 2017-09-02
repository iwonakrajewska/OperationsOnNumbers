import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';

import { TwoNumbersRequest } from './operations/twoNumbersRequest';
import { SingleNumberResponse } from './operations/singleNumberResponse';
import { Config } from '../../shared/properties/config';
import { UtilService } from '../../shared/utils/util.service';
import { AlertService } from '../../shared/alert/alert.service'



@Injectable()
export class NumbersService {
  constructor(private _http: Http, private _config: Config, private _utilService: UtilService, private _alertService: AlertService) {
  }

  callExceptionRequest(twoNumbersRequest: TwoNumbersRequest): Observable<SingleNumberResponse> {
    let body = JSON.stringify(twoNumbersRequest);
    let options = this._utilService.buildRestHeaders();

    return this._http.get(this._utilService.getRestUrl() + "test/exception", options)
      .map((res: Response) => res.json())
      .catch(this.handleError);
  }

  callInvalidServerRequest(twoNumbersRequest: TwoNumbersRequest): Observable<SingleNumberResponse> {
    let body = JSON.stringify(twoNumbersRequest);
    let options = this._utilService.buildRestHeaders();

    return this._http.get("http://localhost:80/dummyUrl", options)
      .map((res: Response) => res.json())
      .catch(this.handleError);
  }

  additionRequest(twoNumbersRequest: TwoNumbersRequest): Observable<SingleNumberResponse> {
    let body = JSON.stringify(twoNumbersRequest);
    let options = this._utilService.buildRestHeaders();

    return this._http.post(this._utilService.getRestUrl() + "addition", body, options)
      .map((res: Response) => res.json())
      .catch(this.handleError);
  }

  subtractionRequest(twoNumbersRequest: TwoNumbersRequest): Observable<SingleNumberResponse> {
    let body = JSON.stringify(twoNumbersRequest);
    let options = this._utilService.buildRestHeaders();

    return this._http.post(this._utilService.getRestUrl() + "subtraction", body, options)
      .map((res: Response) => res.json())
      .catch(this.handleError);
  }

  multiplicationRequest(twoNumbersRequest: TwoNumbersRequest): Observable<SingleNumberResponse> {
    let body = JSON.stringify(twoNumbersRequest);
    let options = this._utilService.buildRestHeaders();

    return this._http.post(this._utilService.getRestUrl() + "multiplication", body, options)
      .map((res: Response) => res.json())
      .catch(this.handleError);
  }

  divisionRequest(twoNumbersRequest: TwoNumbersRequest): Observable<SingleNumberResponse> {
    let body = JSON.stringify(twoNumbersRequest);
    let options = this._utilService.buildRestHeaders();

    return this._http.post(this._utilService.getRestUrl() + "division", body, options)
      .map((res: Response) => res.json())
      .catch(this.handleError);
  }


  private handleError(error: any) {
    let errMsg = (error.message) ? error.message : error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    return Observable.throw(errMsg);
  }



}
