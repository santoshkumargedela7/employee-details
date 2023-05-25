package com.siva.EmployeeDetails.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.siva.EmployeeDetails.dto.EmployeeDataDto;
import com.siva.EmployeeDetails.dto.EmployeeDto;
import com.siva.EmployeeDetails.entity.Employee;
import com.siva.EmployeeDetails.repository.EmployeeRepository;
import com.siva.EmployeeDetails.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public Employee addEmployee(Employee employee) {
		try {
			Employee employee1 = employeeRepository.save(employee);
			logger.info("calling the method add employee in controller:" + employee1);
			return employee1;
		} catch (Exception e) {
			logger.error("exception handled at addEmployee method in serviceImplementation class");
		}
		return null;

	}

	@Override
	public List<Employee> findByisActive(Boolean isActive) {

		try {
			List<Employee> list = employeeRepository.findByisActive(isActive);

			logger.info("list of Employees who are active:" + list);
			return list;
		} catch (Exception e) {
			logger.error("exception raised at findByIsactive method at serviceImpl ", e);
		}
		return null;
	}

	@Override
	public List<Employee> findByfirstName(String firstName) {
		try {
			List<Employee> emp1 = employeeRepository.findByfirstName(firstName);
			logger.info("list of employees by firstName:" + emp1);
			return emp1;
		} catch (Exception e) {
			logger.error("exception raise in findByfirstName method :", e);
		}
		return null;

	}
		public EmployeeDto convertEntityToDto1(Employee employee) {
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setId(employee.getId());
			employeeDto.setFirstName(employee.getFirstName());
			employeeDto.setLastName(employee.getLastName());
			employeeDto.setAddress(employee.getAddress());
			employeeDto.setAge(employee.getAge());
			employeeDto.setIsActive(employee.getIsActive());
			employeeDto.setEmployeeDataDto(new EmployeeDataDto());
			
			return employeeDto;
				
		}
		
		

	@Override
	public List<Employee> getAllEmployees() {

		try {
			List<Employee> listOfEmployees = employeeRepository.findAll();
			logger.info("list of emloyees:" + listOfEmployees);
			return listOfEmployees;
		} catch (Exception e) {
			logger.error("Exception handled at getAllEmployees method at service implementation method ", e);
		}
		return null;

	}

	@Override
	public List<Employee> findBylastName(String lastName) {
		try {
			List<Employee> listOfEmps = employeeRepository.findBylastName(lastName);
			return listOfEmps;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee emp = new Employee();
		emp.setId(employee.getId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setAddress(employee.getAddress());
		emp.setIsActive(employee.getIsActive());
		emp.setAge(employee.getAge());
		emp.setEmployeeData(employee.getEmployeeData());
		Employee emp1 = employeeRepository.save(emp);
		return emp1;
	}

	@Override
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);

	}

	

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {

		try {
			Pageable pegeable = PageRequest.of(pageNo - 1, pageSize);
			return this.employeeRepository.findAll(pegeable);
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Employee getById(Long id) {
		
		try {
			Employee employee = employeeRepository.findById(id).get();
			
			
			logger.info("employeeDetailsById--->"+employee);
			
			return employee;
		} catch (Exception e) {
			
		}
		return null;
		
	}

	@Override
	public List<Employee> findByAge(int age) {
		try {
			List<Employee> list = employeeRepository.findByAge(age);
			logger.info("Details of employee by age--->"+list);
			return list;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public List<Employee> listAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getTheListEmployees() {
		
		return employeeRepository.findAll();
	}

	

}
