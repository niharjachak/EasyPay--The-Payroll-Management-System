package com.hexaware.easyspay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.easyspay.entities.Attendance;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.service.IEmployeeService;

@RestController
@RequestMapping("/api/employeeservice")
public class EmployeeRestController {
	
	@Autowired
	IEmployeeService service;
	
	//View PayStubs
	
	@GetMapping("/paystubs/{empid}")
	public ResponseEntity < List<Payroll>> getPayStubs(@PathVariable int empid){
		
		List<Payroll> paystubs= service.getPayStubs(empid);
		
		return new ResponseEntity<List<Payroll>>(paystubs,HttpStatus.ACCEPTED);
		
	}
	
	
	//Update Personal Information
	
	@PutMapping("/updatepersonalinfo/{empId}")
	public Employee updatePersonalInformation( @PathVariable int empId,  @RequestBody Employee updatedInfo){
		
		return service.updatePersonalInformation(empId, updatedInfo);
	}
	
	//Submit Attendance
	
	@PostMapping("/submitattendance/{empId}")
	public ResponseEntity<Attendance> submitAttendance(@PathVariable int empid, @RequestBody Attendance attendance){
		
		Attendance savedAttendance= service.submitAttendance(empid, attendance);
		ResponseEntity<Attendance>responseEntity = new ResponseEntity<Attendance>(savedAttendance,HttpStatus.CREATED);
		
		return responseEntity;
		
	}
	
	
	//RequestForLeaves
	
	@PostMapping("/requestleave/{empId}")
	public ResponseEntity<Leaves> requestLeave( @PathVariable int empID , @ RequestBody Leaves leaveRequest){
		
		Leaves savedLeaveRequest = service.requestLeave(empID, leaveRequest);
		ResponseEntity<Leaves> responseEntity = new ResponseEntity<>(savedLeaveRequest,HttpStatus.CREATED);
		
		return responseEntity;
	}
	

}
