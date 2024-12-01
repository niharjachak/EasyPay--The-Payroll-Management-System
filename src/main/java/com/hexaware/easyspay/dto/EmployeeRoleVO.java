package com.hexaware.easyspay.dto;


import com.hexaware.easyspay.entities.Role;

public class EmployeeRoleVO{
	
	private  EmpMicroDto employee;
	private  Role role;
	
	
	public EmployeeRoleVO() {
		super();
	}


	public EmployeeRoleVO(EmpMicroDto employee, Role role) {
		super();
		this.employee = employee;
		this.role = role;
	}


	public EmpMicroDto getEmployee() {
		return employee;
	}


	public void setEmployee(EmpMicroDto employee) {
		this.employee = employee;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	
	

}
