package com.example.employeeportal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.employeeportal.constants.Constants;
import com.example.employeeportal.model.Employee;
import com.example.employeeportal.request.RegistrationRequest;
import com.example.employeeportal.service.EmployeeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;



@RestController
@RequestMapping(Constants.BASE_URL)
public class RegistrationController {

	@Autowired
	EmployeeServiceImpl employeeService;

	@PostMapping("/register")
	public ResponseEntity<Object> registerEmployee(@RequestBody RegistrationRequest registrationRequest, HttpServletRequest request) throws JsonProcessingException {

		return  new ResponseEntity<>(employeeService.registerEmployee(registrationRequest, request), HttpStatus.OK);

	}

	@GetMapping("/employees")
	public List<Employee> employees(HttpServletRequest request) throws JsonProcessingException 
	{
		return  employeeService.employees(request);
	}
}
