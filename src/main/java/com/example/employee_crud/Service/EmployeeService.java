package com.example.employee_crud.Service;


import com.example.employee_crud.Entity.Employee;
import com.example.employee_crud.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    //CREATE EMPLOYEE
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //GET ALL EMPLOYEE DETAILS
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    //GET BY ID
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee Not Found"));
    }

    //PATCH
    public Employee patchEmployee(Integer id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        if (employee.getName() != null) {
            existingEmployee.setName(employee.getName());
        }
        if (employee.getEmail() != null) {
            existingEmployee.setEmail(employee.getEmail());
        }
        if (employee.getDepartment() != null) {
            existingEmployee.setDepartment(employee.getDepartment());
        }
        if (employee.getSalary() != null) {
            existingEmployee.setSalary(employee.getSalary());
        }
        if (employee.getDepartmentId() != null) {
            existingEmployee.setDepartmentId(employee.getDepartmentId());
        }
        return employeeRepository.save(existingEmployee);
    }

    //DELETE BY ID
    public void deleteEmployee(Integer id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee Not Found"));
        employeeRepository.delete(employee);
    }

    //Update
    public Employee updateEmployee(Integer id, Employee employee){
        Employee existingEmployee=employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("EMployee Not found"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setEmail(employee.getEmail());


        return employeeRepository.save(existingEmployee);
    }
}