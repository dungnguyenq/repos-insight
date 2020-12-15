import { Component, Input, OnInit } from '@angular/core';
import { Commit } from 'src/app/model/commit.model';
import { HomeService } from '../home.service';
import { MasterService } from '../../../services/master.service'
import { Timeperiod } from 'src/app/model/timeperiod.model';

@Component({
  selector: 'app-commitoverperiodtime',
  templateUrl: './commitoverperiodtime.component.html',
  styleUrls: ['./commitoverperiodtime.component.scss']
})
export class CommitOverPeriodTimeComponent implements OnInit {
  @Input() timePeriod: string = '';

  dataSource: Array<Commit> = [];
  periodTimeDataSource: Array<Timeperiod> = [];
  labelValue: string = '';
  startEndValue: Array<String> = [];
  selected: string = '';

  constructor(
    private homeService : HomeService,
    private masterService : MasterService
  ) { }

  ngOnInit(): void {
    if (this.timePeriod == "week"){
      this.masterService.getWeeks().subscribe(
        (result) => {
          this.periodTimeDataSource = result
          this.labelValue = "Commits week over week"
          this.initial(this.periodTimeDataSource[0])
        }
      )


    } else{
      this.masterService.getMonths().subscribe(
        (result) => {
          this.periodTimeDataSource = result
          this.labelValue = "Commits month over month"
          this.initial(this.periodTimeDataSource[0])
        }
      )
    }
  
  }

  initial(selectedItem: any){
    this.selected = selectedItem.start + '|' + selectedItem.end
    this.getData(selectedItem.start, selectedItem.end)
  }

  onChange(event : any){
    this.startEndValue = event.value.split('|');
    this.getData(this.startEndValue[0], this.startEndValue[1])
  }

  getData(start: String, end: String){
    this.homeService.getCommits(start, end).subscribe(
      (result) => {
        this.dataSource = result
      }
    )
  }
  
}
