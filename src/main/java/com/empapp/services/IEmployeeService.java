package com.empapp.services;

import java.util.List;

import com.empapp.exceptions.EmployeeNotFoundException;
import com.empapp.model.EmployeeDto;


public interface IEmployeeService {
	//CRUD operation
		void addEmployee(EmployeeDto employeeDto);
		void updateEmployee(EmployeeDto employeeDto);
		void deleteEmployee(int employeeId);
		EmployeeDto getById(int employeeId) throws EmployeeNotFoundException;
		List<EmployeeDto> getAll();
		
		//Derived Queries
		List<EmployeeDto> getByDepartment(String department)throws EmployeeNotFoundException;
		List<EmployeeDto> getByProject(String project)throws EmployeeNotFoundException;
		List<EmployeeDto> getByProjLessSalary(String project,double salary)throws EmployeeNotFoundException;

		//native query 
		void updateEmployeeSalary(int employeeId,double salary);
}
