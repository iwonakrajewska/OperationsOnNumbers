import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';

import { Config } from '../shared/properties/config';
import { LoginRequest } from './LoginRequest';
import { UtilService } from '../shared/utils/util.service';


@Injectable()
export class LoginService {
  result: any;

  constructor(
    private _http: Http,
    private _config: Config,
    private _utilService: UtilService
  ) {
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }

  login2(loginRequest: LoginRequest): Observable<any> {
    let options =  this._utilService.buildRestHeaders();
    localStorage.setItem('currentUserToken', JSON.stringify('dummyToken'));
    localStorage.setItem('currentUserName', loginRequest.userName);
    return Observable.from('ok');
  }

  logout() {
    localStorage.clear();
    console.log('Logout. Cleared');
  }

  login(loginRequest: LoginRequest) {
    let options =  this._utilService.buildRestHeaders();
    return this._http.post(this._utilService.getRestUrl()+'login', JSON.stringify(loginRequest), options)
      .map((response: Response) => {        
        let user = response.json();
        if (user && user.token) {
          let tokenValue = JSON.stringify(user.token);
          localStorage.setItem('currentUserToken', tokenValue);
          localStorage.setItem('currentUserName', JSON.stringify(loginRequest.userName));
        }
      });
  }
}
