import { trigger, state, style, animate, transition } from '@angular/animations';
import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [
    trigger('fadeInOnEnter1', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('2000ms 500ms', style({ opacity: 1 }))
      ])
    ]),
    trigger('fadeInOnEnter2', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('2000ms 1500ms', style({ opacity: 1 }))
      ])
    ])
  ]
})
export class AppComponent {
  title = 'AttendanceClient';
  condition1: boolean = true;
  condition2: boolean = true;
}
