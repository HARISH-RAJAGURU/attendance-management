import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { ShowAttendanceByBothService } from '../show-attendance-by-both.service';

import { ToastifyService } from '../toastify.service';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css'],
})
export class DisplayComponent {
  values: any = [];

  outputs: any = [];
  dataSource: any = [];

  displayedColumns: string[] = ['S.No', 'Employee ID', 'Date'];

  formattedDate: string = '';

  private formatDate(date: Date): string {
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const year = date.getFullYear();

    return `${day}-${month}-${year}`;
  }

  constructor(
    private attendanceService: ShowAttendanceByBothService,
    private toastifyService: ToastifyService
  ) {}

  forBoth = new FormGroup({
    id1: new FormControl('', [Validators.required]),
    date: new FormControl(''),
  });

  onSubmit() {
    // this.forBoth.markAllAsTouched();
    if (this.forBoth.valid) {
      this.values.push(this.forBoth.value);
      const dateObject = new Date(this.values[0].date);
      this.formattedDate = this.formatDate(dateObject);

      if (this.formattedDate !== 'NaN-NaN-NaN') {
        const requestData = {
          id: this.values[0].id1,
          date: this.formattedDate,
        };
        this.attendanceService.getAttendanceByBoth(requestData).subscribe(
          (response) => {
            this.toastifyService.ToastifyContainer(
              'Form Submitted Successfully',
              'success'
            );
            this.outputs = response;
            this.dataSource = this.outputs;
            console.log(this.outputs);
            this.forBoth.reset();
          },
          (error) => {
            console.error('Error in fetching attendance:', error);
          }
        );
      } else {
        const requestData = { id: this.values[0].id1 };
        this.attendanceService.getAttendanceByBoth(requestData).subscribe(
          (response) => {
            this.toastifyService.ToastifyContainer(
              'Form Submitted Successfully',
              'success'
            );
            this.outputs = response;
            this.dataSource = this.outputs;
            console.log(this.outputs);
            this.forBoth.reset();
          },
          (error) => {
            console.error('Error in fetching attendance:', error);
          }
        );
      }
    } else {
      this.toastifyService.ToastifyContainer('Form Invalid', 'error');
    }
  }

  id1() {
    return this.forBoth.get('id1');
  }
  date() {
    return this.forBoth.get('date');
  }
}

// show validation inline
// Add clear button next to submit
// Date Range Picker (week)
// ui change display in grid format
// checkbox - All Employees
