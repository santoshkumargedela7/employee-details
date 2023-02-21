package com.siva.EmployeeDetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "toutube_channel", nullable = false)
	private String youTubeChannel;

	@Column(name = "Hobby", nullable = false)
	private String hobby;

}
