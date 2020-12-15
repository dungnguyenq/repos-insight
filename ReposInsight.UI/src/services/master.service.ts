import { Injectable } from '@angular/core';
import { MasterUrl } from 'src/urls/master.url';
import { BaseService } from './base.service'

@Injectable({
  providedIn: 'root'
})
export class MasterService {

  constructor(
    public baseService: BaseService
  ) { }

  getWeeks(){
    const url = MasterUrl.GET_WEEKS
    return this.baseService.getDataList(url)
  }

  getMonths(){
    const url = MasterUrl.GET_MONTHS
    return this.baseService.getDataList(url)
  }
}
