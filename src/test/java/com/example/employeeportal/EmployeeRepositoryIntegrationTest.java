package com.example.employeeportal;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.employeeportal.model.Employee;
import com.example.employeeportal.repository.EmployeeRepository;

import org.junit.After;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

//import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Test
    public void whenRegister_thenReturnEmployee() {
        // given
        Employee alex = new Employee();
        alex.setFirstName("Alex");
        entityManager.persist(alex);
        entityManager.flush();
     
        // when
        Employee found = employeeRepository.findById(alex.getId()).orElse(null);
     
        // then
        assertThat(found.getFirstName())
          .isEqualTo(alex.getFirstName());
        
        
//        Optional<Employee> foundUser = employeeRepository.findById(1L);
//
//        assertThat(foundUser.isPresent()).isEqualTo(true);
//
//        assertThat(foundUser
//          .get()
//          .getFirstName()).isEqualTo("Name");
    }
    
    @Test
    public void whenFindAll_thenReturnEmployees() {
    	// given
    	List<Employee> employees =  new ArrayList<>();
        Employee alex = new Employee();
        alex.setFirstName("Alex");
        entityManager.persist(alex);
        entityManager.flush();
        
        Employee tom = new Employee();
        tom.setFirstName("Tom");
        entityManager.persist(tom);
        entityManager.flush();
        employees.add(alex);
        employees.add(tom);
        
        List<Employee> employeeList = employeeRepository.findAll();
        
        assertThat(employeeList.equals(employees));
    }
    
    @After
    public void cleanUp() {
    	employeeRepository.deleteAll();
    }
}
