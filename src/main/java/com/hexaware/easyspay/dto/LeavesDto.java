package com.hexaware.easyspay.dto;

import java.time.LocalDate;

public class LeavesDto {

	 private int empId;
	    private LocalDate startDate;
	    private LocalDate endDate;
	    private String leaveType;
	    
	    
		public LeavesDto() {
			super();
		}


		public LeavesDto(int empId, LocalDate startDate, LocalDate endDate, String leaveType) {
			super();
			this.empId = empId;
			this.startDate = startDate;
			this.endDate = endDate;
			this.leaveType = leaveType;
		}


		public int getEmpId() {
			return empId;
		}


		public void setEmpId(int empId) {
			this.empId = empId;
		}


		public LocalDate getStartDate() {
			return startDate;
		}


		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}


		public LocalDate getEndDate() {
			return endDate;
		}


		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}


		public String getLeaveType() {
			return leaveType;
		}


		public void setLeaveType(String leaveType) {
			this.leaveType = leaveType;
		}
	    
	    
	    
}
