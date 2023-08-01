import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employee : Employee = new Employee();

  constructor(private employeeService : EmployeeService,
     private router : Router){}

  ngOnInit(): void {
    console.log('create employee')
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }

  saveEmployee() {
    this.employeeService.createEmployee(this.employee).subscribe(response => {
      console.log("create employee response" + JSON.stringify(response));
      this.moveToEmployeeList();
    },
      error => console.log("error while creating employee " + error));
  }

  moveToEmployeeList(){
    this.router.navigate(['/employees']);
  }
}
