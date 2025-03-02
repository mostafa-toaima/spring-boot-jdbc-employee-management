package com.mtoaima.jdbc_project.orm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtoaima.jdbc_project.orm.Entity.Employee;
import com.mtoaima.jdbc_project.orm.exception.EmployeeNotFoundException;
import com.mtoaima.jdbc_project.orm.repository.EmployeeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	
//	@Autowired  way but i make by  another way by constructor
//	private EmployeeRepository employeeRepository;
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeController(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	

	@GetMapping("/count")
	public long countEmp() {
		return employeeRepository.count();
	}
	
	

	@GetMapping("")
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}	
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/filter/{id}")
	public Employee findById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		if (employee == null) {
			throw new EmployeeNotFoundException("id " + id +" not found");
		}
		return employee;
		
	}
	@GetMapping("/filter/{name}")
	public List<Employee> filterByName(@PathVariable String name) {
		return employeeRepository.findByName(name);
	}
	
	@GetMapping("/filter/{name}/{salary}")
	public List<Employee> filterByNameAndSalary(@PathVariable String name, @PathVariable Double salary ) {
		return employeeRepository.findByNameAndSalary(name, salary);
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		 employeeRepository.deleteById(id);
	}
	
}
