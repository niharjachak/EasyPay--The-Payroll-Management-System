package com.hexaware.easyspay.entities;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Leaves {
	
	@Id
	private int leaveId;
	private int empId;
	private Date startDate;
	private Date endDate;
	private String status;
	private int managerId;
	

	public Leaves() {
		super();
	}


	public Leaves(int leaveId, int empId, Date startDate, Date endDate, String status, int managerId) {
		super();
		this.leaveId = leaveId;
		this.empId = empId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.managerId = managerId;
	}


	public int getLeaveId() {
		return leaveId;
	}


	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	
}
