import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class ShowAttendanceByBothService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getAttendanceByBoth(data: any): Observable<any> {
    const url = `${this.baseUrl}/attendance-both`;
    console.log(data)
   
    return this.http.post(url, data);
  }

  getAttendanceByBothWithDateRange(data : any) : Observable<any>{
    const url = `${this.baseUrl}/attendance-all-by-date-range`;
    console.log(data)
    return this.http.post(url ,data);
  }
}
