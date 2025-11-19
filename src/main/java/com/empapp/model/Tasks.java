package com.empapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tasks {
	@Id
	@GeneratedValue(generator = "tasks_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "tasks_gen",sequenceName = "tasks_seq", initialValue = 51,allocationSize = 1)
	private Integer taskId;
	private String taskType; //No cost emi,cashback,bank offer //for junir for manager cashier 
	private String description; //role desc
	

}