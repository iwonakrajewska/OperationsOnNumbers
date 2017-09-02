
import { LookupAuxCols } from './lookupAuxCols';

export class Lookup {
  id: number;
  code: string;
  description: string;
  orderSeq: number;
  status: string;
  owner: string;
  beginDate: string;
  endDate: string;
  translations: string;
  idAsInteger: number;
  idAsString: string;
  auxCols: LookupAuxCols[];




  constructor(id: number, code: string, description: string) {
    this.id = id;
    this.code = code;
    this.description = description;
  }
}



