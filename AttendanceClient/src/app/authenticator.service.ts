import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthenticatorService {
  constructor(private http: HttpClient) {}

  private baseUrl = 'http://localhost:8080';
  private isAuthenticatedFlag = false; 

  checkAuth(data: any): Observable<any> {
    const url = `${this.baseUrl}/check-authentication`;
    console.log(data);
    return this.http.post(url, data).pipe(
      tap((response) => {
        if (response === true) {
          this.isAuthenticatedFlag = true;
        }
      })
    );
  }

  isAuthenticated(): boolean {
    return this.isAuthenticatedFlag;
  }
}
