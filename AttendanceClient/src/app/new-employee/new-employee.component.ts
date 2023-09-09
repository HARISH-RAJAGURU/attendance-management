import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NewEmployeeService } from '../new-employee.service';
import { ToastifyService } from '../toastify.service';

@Component({
  selector: 'app-new-employee',
  templateUrl: './new-employee.component.html',
  styleUrls: ['./new-employee.component.css'],
})
export class NewEmployeeComponent {
  values: any = [];

  outputs: any = [];


  date: string = '';

  constructor(private postNewEmployee: NewEmployeeService ,     private toastifyService: ToastifyService
    ) {}

  private formatDate(date: Date): string {
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const year = date.getFullYear();

    return `${day}-${month}-${year}`;
  }

  newEmployee = new FormGroup({
    empName: new FormControl('', [Validators.required]),
    dob: new FormControl('', [Validators.required]),
  });

  onSubmit() {
    if (this.newEmployee.valid) {
      this.values.push(this.newEmployee.value);
      console.log(this.values);

      const dateObject = new Date(this.values[0].dob);

      this.date = this.formatDate(dateObject);
      const requestData = {
        name : this.values[0].empName,
        dob : this.date,
        company : "worldline"
        
      };
      this.postNewEmployee.postEmployeeData(requestData).subscribe(
        (response) => {
          this.toastifyService.ToastifyContainer(
            'Form Submitted Successfully',
            'success'
          );
          this.outputs = response;
          console.log(this.outputs);
          this.newEmployee.reset();
        },
        (error) => {
          console.error('Error in posting Data:', error);
        }
      );
    }
  }

  empName() {
    return this.newEmployee.get('empName');
  }
  dob() {
    return this.newEmployee.get('dob');
  }
}
