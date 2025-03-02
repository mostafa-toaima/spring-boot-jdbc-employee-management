package com.mtoaima.jdbc_project.orm.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table("employees")
public class Employee {	
	
	@Id
	@Column("id")
	private Long employeeId;
	
	@Column("name")
	@Size(min=2, message = "Name Should have at least 2 cahracters")
	@NotNull
	private String name;
	
	@NotNull
	private Double salary;
	
	
	
	public Employee() {
		super();
	
	}
	public Employee(Long employeeId, String name, Double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
