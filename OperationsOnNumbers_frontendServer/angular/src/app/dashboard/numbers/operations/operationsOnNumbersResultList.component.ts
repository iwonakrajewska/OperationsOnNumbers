
import { Component, Input, OnInit, OnDestroy } from '@angular/core';

import { NumbersResultDisplay } from './numbersResultDisplay'
import { Router, ActivatedRoute, RouterLink } from '@angular/router';
@Component({
  selector: 'numbers-result-list',
  templateUrl: './numbers-result-list.component.html'
})
export class OperationsOnNumbersResultListComponent {
  @Input()
  resultList: NumbersResultDisplay[];


}