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

  date1: string = '';
  range1: string = '';
  range2: string = '';
  
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
      view: new FormControl('', [Validators.required]),
      id1: new FormControl('', [Validators.required]),
      // date: new FormControl(''),
      range1: new FormControl(''),
      range2: new FormControl(''),
    });
    
  onSubmit() {
    this.forBoth.markAllAsTouched();
    if (this.forBoth.valid) {
      // console.log(this.forBoth.value);
      this.values.push(this.forBoth.value);
      // const dateObject1 = new Date(this.values[0].date);
      const dateObject2 = new Date(this.values[0].range1);
      const dateObject3 = new Date(this.values[0].range2);
      // this.date1 = this.formatDate(dateObject1);
      this.range1 = this.formatDate(dateObject2);
      this.range2 = this.formatDate(dateObject3);


      if (
        this.forBoth.controls['view'].value === 'HR' &&
        this.range1 !== 'NaN-NaN-NaN' && this.range2 !== 'NaN-NaN-NaN' 
      ) {
        const requestData = {
          id: -1,
          startDate:this.range1,
          endDate:this.range2
        };
        this.attendanceService.getAttendanceByBothWithDateRange(requestData).subscribe(
          (response) => {
            this.toastifyService.ToastifyContainer(
              'Form Submitted Successfully',
              'success'
            );
            this.outputs = response;
            console.log(this.outputs);
            this.forBoth.reset();
          },
          (error) => {
            console.error('Error in fetching attendance:', error);
          }
        );
      }else if (
        this.forBoth.controls['view'].value === 'Employee' &&
        this.range1 !== 'NaN-NaN-NaN' && this.range2 !== 'NaN-NaN-NaN'  
      ) {
        const requestData = {
          id: this.values[0].id1,
          startDate:this.range1,
          endDate:this.range2
        };
        this.attendanceService.getAttendanceByBothWithDateRange(requestData).subscribe(
          (response) => {
            this.toastifyService.ToastifyContainer(
              'Form Submitted Successfully',
              'success'
            );
            this.outputs = response;
            console.log(this.outputs);
            this.forBoth.reset();
          },
          (error) => {
            console.error('Error in fetching attendance:', error);
          }
        );
      }else {
        const requestData = { id: this.values[0].id1 };
        this.attendanceService.getAttendanceByBoth(requestData).subscribe(
          (response) => {
            this.toastifyService.ToastifyContainer(
              'Form Submitted Successfully',
              'success'
            );
            this.outputs = response;
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
  view() {
    return this.forBoth.get('view');
  }
  date() {
    return this.forBoth.get('date');
  }

}
