package com.learning.employeecrudbackend.controller;

import com.learning.employeecrudbackend.model.Employee;
import com.learning.employeecrudbackend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        return new ResponseEntity<>(service.findEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(service.save(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> udpateEmployee(@PathVariable long id, @RequestBody Employee employee){
        return new ResponseEntity<>(service.update(id, employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        service.deleteEmployeeById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


}
