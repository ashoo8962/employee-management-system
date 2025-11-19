package com.empapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Project {
	@Id
	@GeneratedValue(generator = "project_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "project_gen",sequenceName = "project_seq", initialValue = 201,allocationSize = 1)
	private Integer projectId;
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	@ToString.Exclude
	@JsonIgnore
	private List<Employee> employees;
	

}

