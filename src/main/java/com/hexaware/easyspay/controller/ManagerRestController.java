package com.hexaware.easyspay.controller;

/**
 * REST controller for managing manager-related operations such as reviewing team payroll and approving/rejecting leave requests.
 * All endpoints are secured with 'MANAGER' role authorization.
 * 
 * Author: Nihar
 * Date: November 2024
 */


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.service.IManagerService;

@RestController
@RequestMapping("/api/managercontroller/")
public class ManagerRestController {
	
	@Autowired
	private IManagerService managerService;
	
	Logger logger = LoggerFactory.getLogger(ManagerRestController.class);
	
	
	//Review Team Payroll
	
	@GetMapping("/teampayrolls/{managerId}")
	@PreAuthorize("hasAuthority('MANAGER')")
	public ResponseEntity<List<Payroll>> reviewTeamPayroll(@PathVariable int managerId){
	
		List<Payroll> payroll = managerService.reviewTeamPayrolls(managerId);
		
		ResponseEntity<List<Payroll>> responseEntity = new ResponseEntity<>(payroll,HttpStatus.OK);
		logger.info("Team payroll Retrieval Succesfull");
		return responseEntity;
	
		
		
	}
	
	
	@PutMapping("/approveleave/{managerId}/{leaveId}")
	@PreAuthorize("hasAuthority('MANAGER')")
	public ResponseEntity<Leaves> approveRejectLeaveRequest(@ PathVariable int managerId, @PathVariable int leaveId, 
			@RequestParam String status){
		
		Leaves updateLeave = managerService.approveLeaveRequest(managerId, leaveId, status);
		
		ResponseEntity<Leaves> responseEntity = new ResponseEntity<>(updateLeave,HttpStatus.OK);
		logger.info("Approval/Rejection of Leave Request Succesfull");
		return responseEntity;
		
	}
	
	

	
	
	
	
}
