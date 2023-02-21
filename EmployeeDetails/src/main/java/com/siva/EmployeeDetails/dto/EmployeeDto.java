package com.siva.EmployeeDetails.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmployeeDto {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("isActive")
	private Boolean isActive;
	private Set<EmployeeDataDto> employeeDataDto;
	
}
