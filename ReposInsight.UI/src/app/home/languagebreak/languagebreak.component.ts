import { Component, OnInit } from '@angular/core';
import { SingleDataSet, Label } from 'ng2-charts';
import { ChartType, ChartOptions  } from 'chart.js';
import { HomeService} from '../home.service';
import { Language } from 'src/app/model/language.model';


@Component({
  selector: 'app-languagebreak',
  templateUrl: './languagebreak.component.html',
  styleUrls: ['./languagebreak.component.scss']
})
export class LanguagebreakComponent implements OnInit {

  public pieChartLabels: Label[] = [];
  public pieChartData: SingleDataSet = [];
  public pieChartLegend = true;

  public pieChartType: ChartType = 'pie';
  public pieChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      position: 'top',
    },
    plugins: {
      datalabels: {
        
      },
    } 
  };

  public pieChartColors: Array<any> = [
    {
      backgroundColor: [
        'rgba(255, 99, 132, 0.5)',
        'rgba(54, 162, 235, 0.5)',
        'rgba(255, 206, 86, 0.5)',
        'rgba(75, 192, 192, 0.5)',
        'rgba(153, 102, 255, 0.5)',
        'rgba(255, 159, 64, 0.5)',
        'rgba(147, 224, 40, 0.5)',
        'rgba(36, 67, 223, 0.5)',
        'rgba(136, 67, 223, 0.5)',
        'rgba(201, 36, 223, 0.5)',

      ],

    }
  ];

  constructor(
    private homeService : HomeService
  ) { }

  dataSource: Array<Language> = [];

  ngOnInit(): void {
    this.homeService.getLanguages().subscribe(
      (result) => {
        this.dataSource = result;

        this.pieChartData = this.dataSource.map(function(a) { return a["percentage"]});
        this.pieChartLabels = this.dataSource.map(function(a) { return a["name"]});
      }
    )
  }

  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

}
