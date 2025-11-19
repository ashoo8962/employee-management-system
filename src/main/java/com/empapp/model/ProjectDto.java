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
public class ProjectDto {
	private Integer projectId;
	private String projectName;

	@ToString.Exclude
	@JsonIgnore
	private List<Employee> employees;

	public ProjectDto(String projectName) {
		super();
		this.projectName = projectName;
	}

}
