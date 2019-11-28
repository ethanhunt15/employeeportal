package com.example.employeeportal;

import static org.junit.Assert.assertThat;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Java6Assertions.*;

import com.example.employeeportal.model.Employee;
import com.example.employeeportal.repository.EmployeeRepository;
import com.example.employeeportal.request.RegistrationRequest;
import com.example.employeeportal.service.EmployeeService;
import com.example.employeeportal.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Before
	public void setUp() {
		Employee alex = new Employee();
		alex.setFirstName("Alex");
		alex.setId(1L);

		Mockito.when(employeeRepository.findById(alex.getId()).orElse(null))
		.thenReturn(alex);
	}


	@Test
	void savedUserHasRegistrationDate() {

		RegistrationRequest registrationRequest = new RegistrationRequest();
		registrationRequest.setFirstName("FN");
		registrationRequest.setLastName("LN");
		registrationRequest.setDepartment("department");
		registrationRequest.setDob(1200000L);
		registrationRequest.setGender(1);

		Employee savedUser = employeeService.registerEmployee(registrationRequest);
		assertThat(savedUser.getRegistrationDate()).isNotNull();
	}

	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		//        String name = "alex";
		//        Employee found = employeeService.getEmployeeByName(name);
		//      
		//         assertThat(found.getName())
		//          .isEqualTo(name);
	}

}
