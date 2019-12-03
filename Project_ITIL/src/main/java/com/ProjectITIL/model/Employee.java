package com.ProjectITIL.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	@NotNull
	@Size(min = 4, max = 15, message="Name should have atleast four characters")
	@Column(name = "employee_Name", length = 15)
	private String employeeName;
	@Id
	@Column(name = "employee_Id", length = 5)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@NotNull
	@Size(min = 8, max = 15,message="Password should have atleast 8 characters")
	@Column(name = "password", length = 15)
	private String password;
	@Column(name = "employee_Role", length = 15)
	private String employeeRole;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
}
