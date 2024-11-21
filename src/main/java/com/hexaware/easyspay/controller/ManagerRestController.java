package com.hexaware.easyspay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
	//Review Team Payroll
	
	@GetMapping("/teampayrolls/{managerId}")
	public ResponseEntity<List<Payroll>> reviewTeamPayroll(@PathVariable int managerId){
	
		List<Payroll> payroll = managerService.reviewTeamPayrolls(managerId);
		
		ResponseEntity<List<Payroll>> responseEntity = new ResponseEntity<>(payroll,HttpStatus.OK);
		return responseEntity;
	
		
		
	}
	
	
	@PutMapping("/approveleave/{managerId}/leaveId")
	public ResponseEntity<Leaves> approveRejectLeaveRequest(@ PathVariable int managerId, @PathVariable int leaveId, 
			@RequestParam String status){
		
		Leaves updateLeave = managerService.approveLeaveRequest(managerId, leaveId, status);
		
		ResponseEntity<Leaves> responseEntity = new ResponseEntity<>(updateLeave,HttpStatus.OK);
		
		return responseEntity;
		
	}
	
	

	
	
	
	
}
