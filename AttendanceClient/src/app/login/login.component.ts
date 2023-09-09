import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ToastifyService } from '../toastify.service';
import { AuthenticatorService } from '../authenticator.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  values: any = [];
  output: any = "";

  constructor(
    private toastifyService: ToastifyService,
    private authService: AuthenticatorService,
    private router: Router
  ) {}

  authentication = new FormGroup({
    empEmail: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  onSubmit() {
    this.authentication.markAllAsTouched();

    if (this.authentication.valid) {
      this.values.push(this.authentication.value);
      console.log(this.values);

      const requestData = {
        email: this.values[0].empEmail,
        password: this.values[0].password,
      };

      this.authService.checkAuth(requestData).subscribe(
        (res) => {
          this.toastifyService.ToastifyContainer(
            'Form Submitted Successfully',
            'success'
          );
          this.output = res;
          console.log(this.output);

          // Assuming the server returns true if authentication is successful
          if (this.output === true) {
            this.router.navigate(['/home']);
          } else {
            this.toastifyService.ToastifyContainer(
              'Authentication Failed',
              'error'
            );
          }
        },
        (error) => {
          console.error('Error in Authentication', error);
        }
      );
    } else {
      this.toastifyService.ToastifyContainer('Form Invalid', 'error');
    }
  }

  empEmail() {
    return this.authentication.get('empEmail');
  }

  password() {
    return this.authentication.get('password');
  }
}
