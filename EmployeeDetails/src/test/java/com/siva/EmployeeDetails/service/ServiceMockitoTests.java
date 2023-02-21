/*
 * package com.siva.EmployeeDetails.service;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.jupiter.api.Order; import org.junit.jupiter.api.Test; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.siva.EmployeeDetails.entity.Employee; import
 * com.siva.EmployeeDetails.repository.EmployeeRepository; import
 * com.siva.EmployeeDetails.serviceImpl.EmployeeServiceImpl;
 * 
 * @SpringBootTest(classes = { ServiceMockitoTests.class }) public class
 * ServiceMockitoTests {
 * 
 * @Mock EmployeeRepository employeeRepository;
 * 
 * @InjectMocks EmployeeServiceImpl employeeServiceImpl;
 * 
 * public List<Employee> employees;
 * 
 * @Test
 * 
 * @Order(1) void test_getAllEmployees() { List<Employee> employees = new
 * ArrayList<Employee>(); Employee emp = new Employee(1L, "kummaran", "nagar",
 * 40,"kumaranNagar", true); employees.add(emp);
 * 
 * 
 * when(employeeRepository.findAll()).thenReturn(employees);// mocking
 * System.out.println("EmployeesData--->" + employees); assertEquals(1,
 * employeeServiceImpl.getAllEmployees().size()); }
 * 
 * @Test
 * 
 * @Order(2) void test_getById() { List<Employee> employees = new
 * ArrayList<Employee>(); Employee emp = new Employee(1L, "kummaran", "nagar",
 * 40,"kumaranNagar", true); employees.add(emp);
 * 
 * 
 * Long id = 1L; when(employeeRepository.findAll()).thenReturn(employees);
 * 
 * System.out.println(employees); assertEquals(id,
 * employeeServiceImpl.getById(id).getId());
 * 
 * }
 * 
 * }
 */