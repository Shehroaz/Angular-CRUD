import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';



@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseURL: string = "http://localhost:8012/api/v1"

  constructor(private httpClient : HttpClient) { }

  getEmployeeList() : Observable<Employee[]>{
    
    return this.httpClient.get<Employee[]>(this.baseURL + "/employees");
  }
}