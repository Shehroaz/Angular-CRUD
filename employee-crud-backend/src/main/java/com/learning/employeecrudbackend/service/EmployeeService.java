package com.learning.employeecrudbackend.service;

import com.learning.employeecrudbackend.exception.ResourceNotFoundException;
import com.learning.employeecrudbackend.model.Employee;
import com.learning.employeecrudbackend.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(long id){
        return employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id : " + id));

    }


    public Employee save(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee update(long id , Employee employeeDetails){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id : " + id));

        Employee toBeUpdated = Employee.builder()
                .firstName(employeeDetails.getFirstName())
                .lastName(employeeDetails.getLastName())
                .email(employeeDetails.getEmail())
                .build();
        
        return employeeRepo.save(toBeUpdated);
    }

    public void deleteEmployeeById(long id){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id : " + id));

        employeeRepo.delete(employee);
    }



}
