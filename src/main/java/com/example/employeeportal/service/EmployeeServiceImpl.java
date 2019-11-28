package com.example.employeeportal.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeportal.model.Employee;
import com.example.employeeportal.repository.EmployeeRepository;
import com.example.employeeportal.request.RegistrationRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee registerEmployee(RegistrationRequest registrationRequest)
	{
		Employee employee = new Employee();
		BeanUtils.copyProperties(registrationRequest, employee);
		employee.setRegistrationDate(new Date());
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> employees()
	{
		List<Employee> employeeList = employeeRepository.findAll();
		Comparator<Employee> compareById = (Employee o1, Employee o2) -> o1.getFirstName().compareTo( o2.getFirstName() );
		Collections.sort(employeeList, compareById);
		return employeeList;
	}
}
