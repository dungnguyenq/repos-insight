import { Component, OnInit } from '@angular/core';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import { Color, Label } from 'ng2-charts';
import { Committer } from 'src/app/model/committer.model';
import {HomeService} from '../home.service'

@Component({
  selector: 'app-toptencommitter',
  templateUrl: './toptencommitter.component.html',
  styleUrls: ['./toptencommitter.component.scss']
})
export class ToptencommitterComponent implements OnInit {

  chartType: ChartType ='horizontalBar';

  public chartDatasets: ChartDataSets[] = []

  public chartLabels: Label[] = [];

  public chartColors: Array<any> = [
    {
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)',
        'rgba(147, 224, 40, 0.2)',
        'rgba(36, 67, 223, 0.2)',
        'rgba(136, 67, 223, 0.2)',
        'rgba(201, 36, 223, 0.2)',

      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)',
        'rgba(147, 224, 40, 1)',
        'rgba(36, 67, 223, 1)',
        'rgba(136, 67, 223, 0.2)',
        'rgba(201, 36, 223, 0.2)',
        
      ],
      borderWidth: 2,
    }
  ];

  public chartOptions: any = {
    responsive: true
  };

  public lineChartLegend = true;
  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }


  dataSource: Array<Committer> = [];

  
  constructor(private homeService : HomeService) { }

  ngOnInit(): void {
    this.homeService.getTopTenCommiters().subscribe(
      (result) => {
        this.dataSource = result;

        this.chartDatasets = [
          { data: this.dataSource.map(function(a) { return a["commit_count"]}), label: 'Commits' },
        ];
        this.chartLabels = this.dataSource.map(function(a) { return a["display_name"]});
      }
    )
  }

};
