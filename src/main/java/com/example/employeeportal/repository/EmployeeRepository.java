package com.example.employeeportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeeportal.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
