package com.empapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmployeeDto {

	private String employeeName;
	private Integer employeeId;
	private double salary;
	private Informationes informationes;
	private List<Tasks> tasks;
	private Department department;
	private List<Project> projects;
	private List<String> languagesKnown; // COD,UPI,CREDITCARD,DEBITCARD
	private List<String> roleTypes; // standard, prime,free

}
