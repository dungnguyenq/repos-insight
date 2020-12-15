import { Injectable } from '@angular/core';
@Injectable()
export class LanguageUrl {
  public static get GET_LANGUAGES() : string {return '/api/v1/languages/all'}
}

