package com.siva.EmployeeDetails.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.siva.EmployeeDetails.entity.Employee;

public interface EmployeeService {

		public Employee addEmployee(Employee employee);

		public List<Employee> findByisActive(Boolean isActive);

		public List<Employee> findByfirstName(String firstName);

		public List<Employee> getAllEmployees();

		public List<Employee> findBylastName(String lastName);

		public Employee updateEmployee(Employee employee);

		public void deleteById(Long id);

		
		Page<Employee> findPaginated(int pageNo,int pageSize);

		public Employee getById(Long id);

		public List<Employee> findByAge(int age);

		public List<Employee> listAll();

		public List<Employee> getTheListEmployees();


		




		

}
