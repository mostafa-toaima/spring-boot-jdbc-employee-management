package com.mtoaima.jdbc_project.orm.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtoaima.jdbc_project.orm.Entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findByName(String name);
	
	
	List<Employee> findByNameAndSalary(String name, Double salary);
	
	//search for query creation containing and startWith greaterThan and like etc..;
	
	
	//custom Query
	@Query(value = "SELECT * FROM employees where name LIKE :empName and salary => :empSalary")
	List<Employee> findByCustomQuery(@Param("empName")String name, @Param("empSalary") Double salary);


}
