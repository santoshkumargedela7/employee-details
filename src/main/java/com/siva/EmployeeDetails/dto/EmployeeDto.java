package com.siva.EmployeeDetails.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private int age;
	private Boolean isActive;

	private EmployeeDataDto employeeDataDto;
	
}
