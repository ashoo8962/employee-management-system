package com.empapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class DepartmentDto {
	private Integer departmentId;
	private String departmentName;

	@ToString.Exclude
	@JsonIgnore
	private List<Employee> employees;

	public DepartmentDto(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

}
