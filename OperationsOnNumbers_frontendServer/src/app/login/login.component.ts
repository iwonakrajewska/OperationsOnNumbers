import { Component, Input, OnInit } from '@angular/core';
import { LoginRequest } from './loginRequest';
import { LoginService } from './login.service';

import { Router, ActivatedRoute } from '@angular/router';
import { AlertService } from '../shared/alert/alert.service';
import { Config } from '../shared/properties/config';


/**
*  This class represents the lazy loaded LoginComponent.
*/

@Component({
  selector: 'login-cmp',
  templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
  model: LoginRequest;
  errorMessage: string;
  token: string;
  loading = false;
  returnUrl: string;

  constructor(private _loginService: LoginService,
    private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertService,
    private config: Config) {

  }

  ngOnInit() {
    this._loginService.logout();
    this.model = new LoginRequest('', '');
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/dashboard/numbers';
    this.config.loadConfiguration();
  }

  onSubmit() {
    this.loading = true;

    this._loginService.login(this.model)
      .subscribe(
      data => {
        this.alertService.success('Login successfull');
        this.loading = false;
        this.router.navigate([this.returnUrl]);
      },
      error => {
        console.log("login server error: " + error);
        this.alertService.error('Login incorrect');
        this.loading = false;
      });

  }

}
