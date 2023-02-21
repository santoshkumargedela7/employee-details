package com.siva.EmployeeDetails.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", nullable = false)
	private Long id;

	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private Boolean isActive;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_details")
	private EmployeeData employeeData;

	public Employee(Long id, String firstName, String lastName, int age, String address, Boolean isActive) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.isActive = isActive;
	}

	

	

	

}
