import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Lookup } from './lookup';
import { Config } from "../../shared/properties/config";
import { UtilService } from "../../shared/utils/util.service";


@Injectable()
export class LookupService {
  cachedLookup: Map<string, Lookup[]> = new Map<string, Lookup[]>();
  maxItems: number = 10;

  constructor(private _http: Http, private _utilService: UtilService) { }



  getLookup(lookupCode: string): Observable<Lookup[]> {

    let cachedValue = this.cachedLookup.get(lookupCode);
    if (cachedValue != null) {
      console.log("Cache HIT! " + lookupCode);
      return Observable.of(cachedValue);
    }

    let options = this._utilService.buildRestHeaders();
    return this._http.get(this._utilService.getRestUrl() + 'lookup/list/' + lookupCode, options)
      .map((response: Response) => <Lookup[]>response.json())
      .do(data => {
        console.log('Caching ' + lookupCode + ': ' + JSON.stringify(data));
        this.cachedLookup.set(lookupCode, data);
        this.deleteOverflowing();
      })
      .catch(this.handleError);
  }





  getLookupByCode(lookupList: Lookup[], code: string): Lookup {
    if (lookupList) {
      for (let lookupEntry of lookupList) {
        if (lookupEntry.code === code) {
          return lookupEntry;
        }
      }
    }
    return this.getEmptyLookup();
  }

  getLookupAuxColValue(lookup: Lookup, auxCol: string): string {
    if (lookup) {
      if (lookup.auxCols) {
        for (let auxColName of lookup.auxCols) {
          if (auxColName.name === auxCol) {
            return auxColName.value;
          }
        }
      }
    }
    return '';
  }

  getEmptyLookup(): Lookup {
    return new Lookup(0, '', 'Select one');
  }




  private handleError(error: Response) {
    // in a real world app, we may send the server to some remote logging infrastructure
    // instead of just logging it to the console
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }



  private deleteOverflowing(): void {
    console.log('this.cachedData.size ' + this.cachedLookup.size);
    if (this.cachedLookup.size > this.maxItems) {
      this.deleteOldest(this.cachedLookup.size - this.maxItems);
    }
  }

  /// A Map object iterates its elements in insertion order — a for...of loop returns an array of [key, value] for each iteration.
  /// However that seems not to work. Trying with forEach.
  private deleteOldest(howMany: number): void {
    //console.debug("Deleting oldest " + howMany + " of " + this.cachedData.size);
    let iterKeys = this.cachedLookup.keys();
    let item: IteratorResult<string>;
    while (howMany-- > 0 && (item = iterKeys.next(), !item.done)) {
      //console.debug("    Deleting: " + item.value);
      this.cachedLookup.delete(item.value); // Deleting while iterating should be ok in JS.
    }
  }

  clear(): void {
    this.cachedLookup = new Map<string, Lookup[]>();
  }

}
