package com.empapp.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empapp.exceptions.DepartmentNotFoundException;
import com.empapp.model.Department;
import com.empapp.model.DepartmentDto;
import com.empapp.repository.IDepartmentRepository;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public void addDepartment(DepartmentDto departmentDto) {
		Department department = mapper.map(departmentDto, Department.class);
		departmentRepository.save(department);
	}

	@Override
	public void updateDepartment(DepartmentDto departmentDto) {
		Department department = mapper.map(departmentDto, Department.class);
		departmentRepository.save(department);

	}

	@Override
	public void deleteDepartment(int departmentId) {
		departmentRepository.deleteById(departmentId);

	}

	@Override
	public DepartmentDto getById(int departmentId) throws DepartmentNotFoundException {
		Department department= departmentRepository.findById(departmentId)
				  .orElseThrow(()-> new DepartmentNotFoundException("invalid dept"));
				return mapper.map(department, DepartmentDto.class);
	}

}
