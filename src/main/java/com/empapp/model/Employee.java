package com.empapp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {
	@Column(length = 20)
	private String employeeName;
	@Id
	@GeneratedValue(generator = "employee_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq")
	private Integer employeeId;

	@Column(name = "salary")
	private double salary;
	// save the child entity before the parent entity
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "informationes_id")
	private Informationes informationes;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id") // foreign key in offers table
	private List<Tasks> tasks;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projects;

	@ElementCollection
	@CollectionTable(name = "language", joinColumns = @JoinColumn(name = "employee_id"))
	private List<String> languagesKnown; // COD,UPI,CREDITCARD,DEBITCARD

	@ElementCollection
	@CollectionTable(name = "role", joinColumns = @JoinColumn(name = "employee_id"))
	private List<String> roleTypes; // standard, prime,free

}
