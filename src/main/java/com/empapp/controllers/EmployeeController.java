package com.empapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.model.EmployeeDto;
import com.empapp.model.EmployeeSalaryDto;
import com.empapp.services.IEmployeeService;

@RestController
@RequestMapping("/employee-api/v1")
public class EmployeeController {
	
		@Autowired
	    private IEmployeeService employeeService;
	
//		http://localhost:8081/employee-api/v1/employees
	    @PostMapping("/employees")
		ResponseEntity<Void> addEmployee(@RequestBody EmployeeDto employeeDto) {
	    	employeeService.addEmployee(employeeDto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	    
//		http://localhost:8081/product-api/v1/employees
	    @PutMapping("/employees")
		ResponseEntity<Void> updateEmployee(@RequestBody EmployeeDto employeeDto){
	    	employeeService.updateEmployee(employeeDto);
			HttpHeaders headers =  new HttpHeaders();
			headers.add("info","updating one emp");
			headers.add("desc", "update method called");
			return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
		}
	    
//		http://localhost:8081/employee-api/v1/employees
	    @PatchMapping("/employees/newsalary")
		ResponseEntity<Void> updateEmployeeSalary(@RequestBody EmployeeSalaryDto employeeSalaryDto){
	    	double salary = employeeSalaryDto.getSalary();
	    	int employeeId = employeeSalaryDto.getEmployeeId();
	    	employeeService.updateEmployeeSalary(employeeId, salary);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
	    
//	    http://localhost:8081/employee-api/v1/employees/employeeId/2
	    @DeleteMapping("/employees/employeeId/{employeeId}")
		ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId){
	    	employeeService.deleteEmployee(employeeId);
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","deleting one emp by id");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
	    }
		
//	    http://localhost:8081/product-api/v1/products/productId/1
		@GetMapping("/employees/employeeId/{employeeId}")
		ResponseEntity<EmployeeDto> getById(@PathVariable int employeeId) {
			EmployeeDto employeeDto =  employeeService.getById(employeeId);
			HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting one emp by id");
			return ResponseEntity.ok().headers(headers).body(employeeDto);
		}
		
//		 http://localhost:8081/product-api/v1/products
		@GetMapping("/employees")
		ResponseEntity<List<EmployeeDto>> getAll(){
			List<EmployeeDto> productDtos = employeeService.getAll();
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting all em;ps");
			return ResponseEntity.ok().headers(headers).body(productDtos);
		}
		
//		 http://localhost:8081/product-3api/v1/products/brand/Samsung
		@GetMapping("/employees/department/{departmentName}")
		ResponseEntity<List<EmployeeDto>> getByDepartment(@PathVariable String department){
			List<EmployeeDto> employeeDtos = employeeService.getByDepartment(department);
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting all products by dept");
			return new ResponseEntity<List<EmployeeDto>>(employeeDtos, headers, HttpStatus.OK.value());
		}
//		 http://localhost:8081/product-api/v1/products/category?category=electronics
		@GetMapping("/employees/project")
		ResponseEntity<List<EmployeeDto>> getByProject(@RequestParam String project){
			List<EmployeeDto> employeeDtos = employeeService.getByProject(project);
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting all emps by projects");
			return ResponseEntity.ok().headers(headers).body(employeeDtos);
			
		}
//		http://localhost:8081/product-api/v1/products/category/Electronics/price/20000
		@GetMapping("/employees/project/{project}/salary/{salary}")
		ResponseEntity<List<EmployeeDto>> getByProjLessSalary(@PathVariable String project,@PathVariable double salary){
			List<EmployeeDto> employeeDtos = employeeService.getByProjLessSalary(project, salary);
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting all emps by proj and less sal");
			return ResponseEntity.ok().headers(headers).body(employeeDtos);
		}

		
		

}
