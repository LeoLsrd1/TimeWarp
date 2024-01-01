import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class ChangeUsernameService {

  private baseUrl = '/serverapi/'; 

 
  constructor(private http: HttpClient) { }

  change_username(userDTO: any): Observable<any> {
    const url = `${this.baseUrl}/user/changeusername`;    
    return this.http.patch(url, userDTO);
  }
}
