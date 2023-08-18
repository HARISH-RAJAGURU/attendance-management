import { Component, Inject , OnInit} from '@angular/core';
import { MAT_SNACK_BAR_DATA, MatSnackBarRef } from '@angular/material/snack-bar';

@Component({
  selector: 'app-toast',
  templateUrl: './toast.component.html',
  styleUrls: ['./toast.component.css']
})
export class ToastComponent implements OnInit{
  messagetype: string | undefined;

  constructor(@Inject(MAT_SNACK_BAR_DATA) public data:any,
  public snackBarRef:MatSnackBarRef<ToastComponent>
  ){}

  ngOnInit() {
    // Set the messagetype based on data passed from ToastifyService
    this.messagetype = this.data.messagetype;
  }

}
