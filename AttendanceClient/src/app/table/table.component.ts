import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {
  displayedColumns: string[] = ['S.No', 'Employee ID', 'Date'];
  @Input("dataInput")  dataSource:any=[]

  // constructor(private cd: ChangeDetectorRef) {}

  getData(){
    // this.cd.detectChanges();
    console.log(this.dataSource)
  }
}
