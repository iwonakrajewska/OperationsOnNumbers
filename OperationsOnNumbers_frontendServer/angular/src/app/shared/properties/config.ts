import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import { AlertService } from '../alert/alert.service';

@Injectable()
export class Config {
  private _configurationEnvironmentUrl = 'app/resources/env.json';
  private _configurationPropertiesPath = 'app/resources/';
  private _configurationPropertiesUrl: string;  // = 'app/resources/dev.json';


  constructor(private _http: Http, private alertService: AlertService) {
  }
  //https://medium.com/@hasan.hameed/reading-configuration-files-in-angular-2-9d18b7a6aa4#.x6qdiif2a


  get(key: string) {
    let environmentProperties = JSON.parse(localStorage.getItem('EnvironmentProperties'));
    if (environmentProperties) {     
      return environmentProperties[key];
    }
    console.log('Properies not ready yet, key: ' + key);
    this.loadConfiguration();
  }


  loadConfiguration() {
    let environmentProperties = JSON.parse(localStorage.getItem('EnvironmentProperties'));
    if (environmentProperties) {
      console.log("EnvironmentProperties already loaded");
      return;
    }
    this.loadEnvironmentProperties();
  }



  private loadEnvironmentProperties() {
    this._http.get(this._configurationEnvironmentUrl)
      .map(res => res.json())
      .subscribe(
      (env_data) => {
        let environmentContent = (env_data);
        let fileContent = JSON.parse(JSON.stringify(environmentContent));
        this._configurationPropertiesUrl = this._configurationPropertiesPath + fileContent['environment'];
        console.log('Loading properties from environmentFile: ' + this._configurationPropertiesUrl);
      this.storeEnvironmentproperties();
      },
      error => {
        console.log("Loading EnvironmentFile: " + error);
        this.alertService.error('Loading EnvironmentFile failed');
      }
      );
  }

  private storeEnvironmentproperties() {
    this.loadConfigurationProperties()
      .subscribe(prop => {
        localStorage.setItem('EnvironmentProperties', JSON.stringify(prop));
      },
      error => {
        this.alertService.error('EnvironmentProperties loading failed ');
      });
  }


  private loadConfigurationProperties(): Observable<Object> {
    return this._http.get(this._configurationPropertiesUrl)
      .map((response: Response) => <Object>response.json())
      .do(data => {})
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.status || 'Environment Properties loading failed');
  }

};