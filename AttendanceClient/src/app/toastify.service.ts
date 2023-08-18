import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ToastComponent } from './toast/toast.component';

@Injectable({
  providedIn: 'root',
})
export class ToastifyService {
  constructor(private snackBar: MatSnackBar) {}

  Toastify(message: string) {
    this.snackBar.open(message, 'Close', {
      duration: 3000,
      panelClass: 'toast',
      horizontalPosition: 'end',
      verticalPosition: 'top',
      
    });
  }

  ToastifyContainer(message: string ,messagetype:string) {

    this.snackBar.openFromComponent(ToastComponent, {
      data: {
        message: message,
        messagetype: messagetype,
      },

      duration: 3000,
      panelClass: 'error',
      horizontalPosition: 'end',
      verticalPosition: 'top',
    });
  }
}
