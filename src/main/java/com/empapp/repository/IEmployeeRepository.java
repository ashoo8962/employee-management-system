package com.empapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.empapp.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	// derived
//	List<Product> findByBrandBrandName(String brand);

	@Query("from Employee e inner join e.department d where d.departmentName=?1")
	List<Employee> findByDepartment(String department);

	// derived
//	List<Product> findByCategoriesCategoryName(String category);

	@Query("from Employee e inner join e.projects p where p.projectName=?1")
	List<Employee> findByProject(String project);

	@Query("""
			from Employee e inner join e.projects p where p.projectName=?1
			and e.salary <=?2
			""")
	List<Employee> findByProjectSalary(String project, double salary);

	// use column name and table name
	@Query(value = "update employee set salary=?2 where employee_id=?1", nativeQuery = true)
	@Modifying
	void updateEmployee(int employeeId, double salary);

	//List<Employee> findByProject(String project);

//	List<Employee> findByProjLessSalary(String project, double salary);
//
//	List<Employee> findByProjLessSalary(String project, double salary);

	

	

	

}
