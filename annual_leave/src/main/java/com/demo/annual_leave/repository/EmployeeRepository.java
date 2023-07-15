package com.demo.annual_leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
        Employee findEmployeeById(int id);
    
        Employee createEmployee(Employee employee);
    
        Employee updateEmployee(Employee employee);
    
        String deleteEmployee(int id);
    
}