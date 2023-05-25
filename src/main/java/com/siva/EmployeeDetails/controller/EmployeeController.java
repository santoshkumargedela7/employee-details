package com.siva.EmployeeDetails.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.DocumentException;
import com.siva.EmployeeDetails.entity.Employee;
import com.siva.EmployeeDetails.service.EmployeeService;
import com.siva.EmployeeDetails.util.ExcelGenerator;
import com.siva.EmployeeDetails.util.PdfGenerator;

@RestController
@RequestMapping("/emp")

public class EmployeeController {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/hello")
	public String hello() {
		return "welcome to my world";
	}
		
	
	@GetMapping("/json")
	public ResponseEntity<String> convertMapToJson() {
		HashMap<String, Object> studentHashmap = new HashMap<String,Object>();
		studentHashmap.put("studentId", 1);
        studentHashmap.put("studentFirstName", "AAA");
        studentHashmap.put("studentLastName", "BBB");
        studentHashmap.put("studentStream", "PCMB");
        studentHashmap.put("studentMarks", "480");
        ObjectMapper mapper = new ObjectMapper();
        try {
			String json = mapper.writeValueAsString(studentHashmap);
			System.out.println("StudentsData:---"+json);
			return new ResponseEntity<String>(json,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
        return null;
	}
	
	
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		try {
			Employee employee1 = employeeService.addEmployee(employee);
			logger.info("EmployeeData--" + employee1);
			return new ResponseEntity<Employee>(employee1, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Exception thrown at add employee method:", e);
		}
		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getById(@PathVariable("id") Long id) {
		Employee employees = employeeService.getById(id);
		logger.info("employeeDetails by id-->" + employees);
		return new ResponseEntity<Employee>(employees, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Employee>> findByisActive(@RequestParam(value = "isActive") Boolean isActive) {
		try {

			List<Employee> emp1 = employeeService.findByisActive(isActive);

			logger.info("ActiveEmployee--" + emp1);
			return new ResponseEntity<List<Employee>>(emp1, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception thrown at controller ", e);
		}
		return null;

	}

	@GetMapping("/name")
	public ResponseEntity<List<Employee>> findByfirstName(@RequestParam(value = "firstName") String firstName) {
		try {
			List<Employee> emp2 = employeeService.findByfirstName(firstName);
			System.out.println("employeeDetails:" + emp2);
			return new ResponseEntity<List<Employee>>(emp2, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("exception thrown at findByFirstName method in controller:", e);
		}
		return null;

	}

	@PostMapping("/data")
	public ResponseEntity<Map<String, String>> getData(@RequestBody Map<String, String> input) {
		System.out.println("Input data -->" + input);
		Map<String, String> response = new HashMap<>();
		response.put("message", "input received");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/users/export/pdf")
	public void exportToPDF(HttpServletResponse response)
			throws DocumentException, IOException, com.itextpdf.text.DocumentException {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users" + currentDateTime + ".pdf";

		response.setHeader(headerKey, headerValue);

		List<Employee> listEmployees = employeeService.listAll();

		PdfGenerator exporter = new PdfGenerator(listEmployees);
		exporter.export(response);
		System.out.println(exporter);

	}

	@GetMapping("/export-to-excel")
	public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=employee" + currentDateTime + ".xlsx";

		response.setHeader(headerKey, headerValue);
		List<Employee> emp = employeeService.getTheListEmployees();
		ExcelGenerator generator = new ExcelGenerator(emp);
		generator.generateExcelFile(response);
	}

	@GetMapping("/all")
	public ResponseEntity<Integer> getAllEmployees() {
		// List<Employee> employee = employeeService.getAllEmployees();

		List<String> names = employeeService.getAllEmployees().stream().map(emp -> emp.getFirstName())
				.collect(Collectors.toList());
		System.out.println(names);

		List<Integer> ages = employeeService.getAllEmployees().stream().map(emp -> emp.getAge())
				.collect(Collectors.toList());

		;
		logger.info("list of ages:" + ages);
		logger.info("Total list of Employees---" + names);

		return new ResponseEntity<Integer>(ages.stream().mapToInt(x -> x).summaryStatistics().getMax(), HttpStatus.OK);
//	return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);

	}

	@GetMapping("/lastName")
	public ResponseEntity<List<Employee>> findBylastName(@RequestParam("lastName") String lastName) {
		try {
			List<Employee> list = employeeService.findBylastName(lastName);
			logger.info("LastName of Employee:" + list);
			return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("exception thrown at findByLastName in controller :", e);
		}
		return null;
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		try {
			Employee employee2 = employeeService.updateEmployee(employee);

			logger.info("updatedEmployee:" + employee2);
			return new ResponseEntity<Employee>(employee2, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception handled in updatedEmployeeMethod:", e);
		}
		return null;

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		employeeService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

	}

	@GetMapping("/age")
	public ResponseEntity<List<Employee>> findByAge(@RequestParam("age") int age) {
		List<Employee> empList = employeeService.findByAge(age);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}

	@GetMapping("/string")
	public String say() {
		System.out.println("Hello");
		return "Hi welcome to this world";
	}

}
