package com.hexaware.easyspay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.easyspay.dto.EmployeeRoleVO;
import com.hexaware.easyspay.service.IRoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	IRoleService service;
	
	
	@GetMapping("/get/employee-role/{empId}")
	@PreAuthorize("hasAuthority('HR')")
	public EmployeeRoleVO getEmployeeAndRoleById(@PathVariable int  empId) {
		
		return service.getEmployeeAndRoleById(empId);
		
	}
	
	
}
