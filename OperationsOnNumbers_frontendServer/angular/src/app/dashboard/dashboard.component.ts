import { Component,  OnInit } from '@angular/core';
import { Config } from "../shared/properties/config";

/**
*  This class represents the lazy loaded DashboardComponent.
*/

@Component({
  selector: 'dashboard-cmp',
  templateUrl: 'dashboard.component.html'
})

export class DashboardComponent implements OnInit {

    constructor( private _config: Config) {  }

  ngOnInit() {
     this._config.loadConfiguration();

  }

 }
