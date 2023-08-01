import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{

  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService){}

  ngOnInit(): void {
    console.log("Employee list component");
    this.getEmployeesList();
  }

  private getEmployeesList(){
    this.employeeService.getEmployeeList().subscribe(response => {
      this.employees = response;
    })
  }

}
