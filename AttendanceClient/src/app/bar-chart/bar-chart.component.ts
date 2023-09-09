import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import * as Highcharts from 'highcharts';

@Component({
  selector: 'app-bar-chart',
  template: `<highcharts-chart [Highcharts]="Highcharts" [options]="chartOptions" style="background-color: #183D3D;"></highcharts-chart>`,
  styleUrls: ['./bar-chart.component.css']
})
export class BarChartComponent implements OnChanges {

  @Input("dataInput") allData: any = {};

  Highcharts: typeof Highcharts = Highcharts;

  chartOptions: Highcharts.Options = {};

  constructor() {}

  ngOnChanges(changes: SimpleChanges) {
    if (changes['allData'] && this.allData) {
      console.log(this.allData)
      this.updateChart();
    }
  }

  updateChart() {
    const chartData = this.allData.map((item: { date: any; empid: any; }) => {
      return {
        name: item.date,
        y: item.empid
      };
    });
  
    this.chartOptions = {
      chart: {
        type: 'column',
      },
      title: {
        text: 'Employee Distribution by Date',
      },
      xAxis: {
        categories: this.allData.map((item: { date: any; }) => item.date),
        title: {
          text: 'Date',
        },
      },
      yAxis: {
        title: {
          text: 'Number of Employees',
        },
      },
      series: [
        {
          type: 'column',
          name: 'Employees',
          data: chartData,
        },
      ],
    };
  }
  
}
