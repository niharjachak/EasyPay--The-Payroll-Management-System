package com.hexaware.easyspay.entities;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Attendance {
	
	@Id
	private int attendanceId;
	private int empId;
	private Date workDate;
	private double workHours;
	private String status;
	

	public Attendance() {
		// TODO Auto-generated constructor stub
	}


	public Attendance(int attendanceId, int empId, Date workDate, double workHours, String status) {
		super();
		this.attendanceId = attendanceId;
		this.empId = empId;
		this.workDate = workDate;
		this.workHours = workHours;
		this.status = status;
	}


	public int getAttendanceId() {
		return attendanceId;
	}


	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public Date getWorkDate() {
		return workDate;
	}


	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}


	public double getWorkHours() {
		return workHours;
	}


	public void setWorkHours(double workHours) {
		this.workHours = workHours;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	

}
