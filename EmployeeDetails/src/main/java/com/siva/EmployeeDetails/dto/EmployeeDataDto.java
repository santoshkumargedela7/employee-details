package com.siva.EmployeeDetails.dto;


import java.util.Set;

import lombok.Data;

@Data
public class EmployeeDataDto {

	private Long id;

	private String youTubeChannel;

	private String hobby;
	private Set<EmployeeDto> employeeDto;
}
