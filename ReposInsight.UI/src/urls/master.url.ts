import { Injectable } from '@angular/core';
@Injectable()
export class MasterUrl {
  public static get GET_WEEKS() : string {return '/api/v1/master/weeks'}
  public static get GET_MONTHS() : string {return '/api/v1/master/months'}
}

