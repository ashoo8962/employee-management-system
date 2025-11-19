package com.empapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Department {
	@Id
	@GeneratedValue(generator = "department_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "department_gen",sequenceName = "department_seq", initialValue = 101,allocationSize = 1)
	private Integer departmentId;
	private String departmentName;
	
	@OneToMany(mappedBy = "department")
	@ToString.Exclude
	@JsonIgnore
	private List<Employee> employees;
	
	

}
