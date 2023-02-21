/*
 * package com.siva.EmployeeDetails.repository;
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertNotEquals; import static
 * org.junit.Assert.assertNotNull;
 * 
 * import java.util.List;
 * 
 * import org.junit.jupiter.api.DisplayName; import org.junit.jupiter.api.Order;
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.TestMethodOrder; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.siva.EmployeeDetails.entity.Employee; import
 * com.siva.EmployeeDetails.entity.EmployeeData;
 * 
 * @SpringBootTest
 * 
 * @TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
 * public class EmployeeRepositoryTest {
 * 
 * @Autowired private EmployeeRepository employeeRepository;
 * 
 * @Test
 * 
 * @DisplayName("CREATING EMPLOYEE")
 * 
 * @Order(1) void create() { Employee employee = new Employee();
 * employee.setId(12L); employee.setFirstName("swamybabu");
 * employee.setLastName("dunga"); employee.setAddress("lingalavalasa");
 * employee.setAge(50); employee.setIsActive(false);
 * 
 * EmployeeData employeeData = new EmployeeData();
 * 
 * employeeData.setId(12L); employeeData.setYouTubeChannel("swamy-ramanamma");
 * employeeData.setHobby("politics"); employee.setEmployeeData(employeeData);
 * employeeRepository.save(employee);
 * 
 * assertNotNull(employeeRepository.findById(12L).get());
 * 
 * }
 * 
 * @Test
 * 
 * @DisplayName("TESTING ALL EMPLOYEES")
 * 
 * @Order(2) void testReadAll() { List<Employee> list =
 * employeeRepository.findAll();
 * 
 * assertThat(list).size().isLessThan(100);
 * assertThat(list).size().isGreaterThan(5);
 * System.out.println("this is the read method"); }
 * 
 * @Test
 * 
 * @DisplayName("TESTING SINGLE EMPLOYEE")
 * 
 * @Order(3) void testSingleEmployee() { Employee employee =
 * employeeRepository.findById(9L).get();
 * 
 * EmployeeData employeeData = employee.getEmployeeData(); assertEquals("kumar",
 * employee.getLastName()); assertEquals("chennai", employee.getAddress());
 * assertEquals("ashwin", employee.getFirstName()); assertEquals(true,
 * employee.getIsActive()); assertEquals("reading", employeeData.getHobby());
 * 
 * }
 * 
 * @Test
 * 
 * @DisplayName("TEST UPDATE METHOD")
 * 
 * @Order(4) void testUpdate() { Employee emp =
 * employeeRepository.findById(12L).get();
 * 
 * emp.setAddress("narasannapeta");
 * 
 * employeeRepository.save(emp); assertNotEquals("lingalavalasa",
 * employeeRepository.findById(12L).get().getAddress()); }
 * 
 * @Test
 * 
 * @Order(5) void testDelete() { employeeRepository.deleteById(12L);
 * assertThat(employeeRepository.existsById(12L)).isFalse(); } }
 */