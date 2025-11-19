package com.empapp.services;

import com.empapp.exceptions.DepartmentNotFoundException;
import com.empapp.model.DepartmentDto;

public interface IDepartmentService {

	// CRUD operation
	void addDepartment(DepartmentDto departmentDto);

	void updateDepartment(DepartmentDto departmentDto);

	void deleteDepartment(int departmentId);

	DepartmentDto getById(int departmentId) throws DepartmentNotFoundException;

}