import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewEmployeeService {

  private baseUrl = 'http://localhost:8080';


  constructor(private http: HttpClient) { }

  postEmployeeData(data:any) :Observable<any>{
    const url = `${this.baseUrl}/post-data`;
    console.log(data)
    return this.http.post(url ,data);

  }
}
