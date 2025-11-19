package com.empapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TasksDto {
	private Integer taskId;
	private String taskType; // No cost emi,cashback,bank offer //for junir for manager cashier
	private String description; // role desc

}