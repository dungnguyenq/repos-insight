import { Injectable } from '@angular/core';
@Injectable()
export class CommitUrl {
  public static get GET_COMMITS() : string {return '/api/v1/commit/all'}
  public static get SYNC_DATA() : string {return '/api/v1/commit/sync'}
}

