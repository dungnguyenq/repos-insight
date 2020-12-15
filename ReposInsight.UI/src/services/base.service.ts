import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpClientModule,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { BaseUrl } from "../urls/base.url";
import { catchError, map, tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class BaseService {

  constructor( private httpClientModule: HttpClientModule,
    private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
    
  private log(message: string) {
    return(message);
  }

  getDataList(url: string): Observable<any>{
    const reqUrl = BaseUrl.API_ENDPOINT + url
    return this.http.get(reqUrl).pipe(
      tap(_=> this.log(`fetched all`))
    )
  }

  syncData(url: string){
      const reqUrl = BaseUrl.API_ENDPOINT + url
      return this.http.post(reqUrl, null).pipe(
        tap((newObject: any) => this.log("sync")),
      )
    }

}
