package com.empapp.services;

import java.util.List;

import com.empapp.exceptions.EmployeeNotFoundException;
import com.empapp.model.Employee;
import com.empapp.model.EmployeeDto;
import com.empapp.repository.IEmployeeRepository;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public void addEmployee(EmployeeDto employeeDto) {
		// convert dto(productDto) in entity(product)
		Employee employee = mapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
		;
	}

	@Override
	public EmployeeDto getById(int employeeId) throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("invalid employeeId"));
		// convert the entity into productDto object
		EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
		return employeeDto;
	}

	@Override
	public List<EmployeeDto> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(employee -> mapper.map(employee, EmployeeDto.class))
				.sorted((p1, p2) -> p1.getEmployeeName().compareTo(p2.getEmployeeName())).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> getByDepartment(String department) throws EmployeeNotFoundException {
		List<Employee> employees = employeeRepository.findByDepartment(department);
		if (employees.isEmpty())
			throw new EmployeeNotFoundException("emp with this department not available");
		return employees.stream().map(employee -> mapper.map(employee, EmployeeDto.class))
				.sorted((p1, p2) -> p1.getEmployeeName().compareTo(p2.getEmployeeName())).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> getByProject(String project) throws EmployeeNotFoundException {
		List<Employee> employees = employeeRepository.findByProject(project);
		if (employees.isEmpty())
			throw new EmployeeNotFoundException("emp with this proj is not available");
		return employees.stream().map(employee -> mapper.map(employee, EmployeeDto.class))
				.sorted((p1, p2) -> p1.getEmployeeName().compareTo(p2.getEmployeeName())).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> getByProjLessSalary(String project, double salary) throws EmployeeNotFoundException {
		List<Employee> employees = employeeRepository.findByProjectSalary(project, salary);
		if (employees.isEmpty())
			throw new EmployeeNotFoundException("emp with this proj and salary is not available");
		return employees.stream().map(employee -> mapper.map(employee, EmployeeDto.class))
				.sorted((p1, p2) -> p1.getEmployeeName().compareTo(p2.getEmployeeName())).collect(Collectors.toList());

	}

	@Override
	@Transactional
	public void updateEmployeeSalary(int employeeId, double salary) {
		employeeRepository.updateEmployee(employeeId, salary);

	}

}
