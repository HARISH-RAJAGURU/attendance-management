import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DisplayComponent } from './display/display.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DateFormatPipe } from './date-format.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatTableModule } from '@angular/material/table';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';

import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { ToastComponent } from './toast/toast.component';


import {MatRadioModule} from '@angular/material/radio';
import { LoginComponent } from './login/login.component';
import { RouterModule,Routes } from '@angular/router';
import { TableComponent } from './table/table.component';
import { BarChartComponent } from './bar-chart/bar-chart.component';

import { HighchartsChartModule } from 'highcharts-angular';
import { NewEmployeeComponent } from './new-employee/new-employee.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';

import {MatCardModule} from '@angular/material/card';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth.guard';



const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'add', component: NewEmployeeComponent, canActivate: [AuthGuard] },
  { path: 'view', component: DisplayComponent, canActivate: [AuthGuard] },
];

@NgModule({
  declarations: [AppComponent, DisplayComponent, DateFormatPipe, ToastComponent, LoginComponent, TableComponent, BarChartComponent, NewEmployeeComponent, NavBarComponent, HomeComponent],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    MatDividerModule,
    MatButtonModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatSnackBarModule,
    MatRadioModule,
    RouterModule.forRoot(appRoutes),
    HighchartsChartModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
