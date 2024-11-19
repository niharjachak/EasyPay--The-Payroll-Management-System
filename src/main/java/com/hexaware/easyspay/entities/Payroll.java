package com.hexaware.easyspay.entities;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="payroll")
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payrollId;
	
	@ManyToOne
	@JoinColumn(name = "emp_id",nullable= false)
	private Employee employee;
	
	@NotNull(message="grosspay cannot be null")
	@DecimalMin(value = "0.0", inclusive = true, message = "Gross pay must be 0 or greater.")
	private double grosspay;
	
	@NotNull(message="Benifits cannot be null")
	@DecimalMin(value = "0.0", inclusive = true, message = "Benefits must be 0 or greater.")
	private double benifits;
	
	@NotNull(message="totalSalary cannot be null")
	

	
	
	private LocalDate payrollDate;

	
	@NotNull(message="Deductions cannot be null")
	@DecimalMin(value = "0.0", inclusive = true, message = "Deductions must be 0 or greater.")
	private double deductions;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	
	public Payroll() {
		super();
	}


	public Payroll(int payrollId, Employee employee,
			@NotNull(message = "grosspay cannot be null") @DecimalMin(value = "0.0", inclusive = true, message = "Gross pay must be 0 or greater.") double grosspay,
			@NotNull(message = "Benifits cannot be null") @DecimalMin(value = "0.0", inclusive = true, message = "Benefits must be 0 or greater.") double benifits,
			@NotNull(message = "totalSalary cannot be null") LocalDate payrollDate,
			@NotNull(message = "Deductions cannot be null") @DecimalMin(value = "0.0", inclusive = true, message = "Deductions must be 0 or greater.") double deductions,
			LocalDate startDate, LocalDate endDate) {
		super();
		this.payrollId = payrollId;
		this.employee = employee;
		this.grosspay = grosspay;
		this.benifits = benifits;
		this.payrollDate = payrollDate;
		this.deductions = deductions;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getGrosspay() {
		return grosspay;
	}

	public void setGrosspay(double grosspay) {
		this.grosspay = grosspay;
	}

	public double getBenifits() {
		return benifits;
	}

	public void setBenifits(double benifits) {
		this.benifits = benifits;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public LocalDate getPayrollDate() {
		return payrollDate;
	}

	public void setPayrollDate(LocalDate payrollDate) {
		this.payrollDate = payrollDate;
	}


	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", employee=" + employee + ", grosspay=" + grosspay + ", benifits="
				+ benifits + ", payrollDate=" + payrollDate + ", deductions=" + deductions + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

	
	
	
	
	
}
