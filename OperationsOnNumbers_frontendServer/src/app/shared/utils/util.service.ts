import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Config } from '../properties/config';

@Injectable()
export class UtilService {

    constructor(private _config: Config) { }

    buildRestHeaders(): RequestOptions {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        headers.append("Access-Control-Allow-Headers", "Content-Type, Authorization");

        let currentUserToken = JSON.parse(localStorage.getItem('currentUserName'));
        if (currentUserToken) {
            currentUserToken = currentUserToken.replace(/[^\x20-\x7E]+/g, '');
            headers.append('Authorization', 'Bearer ' + currentUserToken);
        }

        let options = new RequestOptions({ headers: headers });
        return options;
    }

    getRestUrl(): string {
        return this._config.get('backendServerUrl');
    }
}