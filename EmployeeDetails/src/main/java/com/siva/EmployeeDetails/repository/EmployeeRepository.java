package com.siva.EmployeeDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.EmployeeDetails.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
		
	List<Employee> findByisActive(Boolean isActive);
	
	List<Employee> findByfirstName(String firstName);
	
	
	List<Employee> findByAge(int age);

	List<Employee> findBylastName(String lastName);

	//Boolean  isEmployeeExistsById(long id);


	
	
}
