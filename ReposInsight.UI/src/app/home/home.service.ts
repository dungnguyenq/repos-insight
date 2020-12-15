import { Injectable } from '@angular/core';
import { BaseService } from '../../services/base.service';
import { CommitUrl } from "../../urls/commit.url";
import { CommitterUrl } from '../../urls/committer.url'
import { LanguageUrl } from '../../urls/language.url'

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(
    public baseService: BaseService
  ) { }

  getCommits(start: String, end: String){
    const url = CommitUrl.GET_COMMITS + `?startDate=${start}&endDate=${end}`
    return this.baseService.getDataList(url)
  }

  getTopTenCommiters(){
    const url = CommitterUrl.GET_TOP_TEN_COMMITTER
    return this.baseService.getDataList(url)
  }

  getLanguages(){
    const url = LanguageUrl.GET_LANGUAGES
    return this.baseService.getDataList(url)
  }

  syncData(){
    const url = CommitUrl.SYNC_DATA
    return this.baseService.syncData(url);
  }
}
