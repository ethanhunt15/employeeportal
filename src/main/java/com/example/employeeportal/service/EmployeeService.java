package com.example.employeeportal.service;


import com.example.employeeportal.model.Employee;
import com.example.employeeportal.request.RegistrationRequest;

public interface EmployeeService {
	Employee registerEmployee(RegistrationRequest registrationRequest);

	Object employees();
}
