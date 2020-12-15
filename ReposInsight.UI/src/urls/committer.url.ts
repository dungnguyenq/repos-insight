import { Injectable } from '@angular/core';
@Injectable()
export class CommitterUrl {
  public static get GET_TOP_TEN_COMMITTER() : string {return '/api/v1/committer/top10'}
}

