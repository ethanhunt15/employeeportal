package com.example.employeeportal.service;

import javax.servlet.http.HttpServletRequest;

import com.example.employeeportal.request.RegistrationRequest;

public interface EmployeeService {
	Object registerEmployee(RegistrationRequest registrationRequest, HttpServletRequest request);

	Object employees(HttpServletRequest request);
}
