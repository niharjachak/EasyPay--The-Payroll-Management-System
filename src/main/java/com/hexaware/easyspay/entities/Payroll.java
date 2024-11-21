package com.hexaware.easyspay.entities;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name="payroll")
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payrollId;
	
	@ManyToOne
	@JoinColumn(name = "emp_id",nullable= false)
	private Employee employee;
	
	@NotNull(message="grossPay cannot be null")
	@DecimalMin(value = "0.0", inclusive = true, message = "Gross pay must be 0 or greater.")
	private double grossPay;
	
	@NotNull(message="netPay cannot be null")
	@DecimalMin(value = "0.0", inclusive = true, message = "Gross pay must be 0 or greater.")
	private double netPay;
	
	
	@NotNull(message="Benifits cannot be null")
	@DecimalMin(value = "0.0", inclusive = true, message = "Benefits must be 0 or greater.")
	private double benefits;
	
	@NotNull(message="Deductions cannot be null")
	@DecimalMin(value = "0.0", inclusive = true, message = "Deductions must be 0 or greater.")
	private double deductions;
	
	
	private LocalDate startDate;
	
	
	private LocalDate endDate;
	
	
	@NotNull(message = "Payroll date must not be null.")
    @PastOrPresent(message = "Payroll date cannot be in the future.")
	private LocalDate payrollDate;

	
	
	
	
	
	
	public Payroll() {
		super();
	}



	public Payroll(int payrollId, Employee employee,
			@NotNull(message = "grossPay cannot be null") @DecimalMin(value = "0.0", inclusive = true, message = "Gross pay must be 0 or greater.") double grossPay,
			@NotNull(message = "netPay cannot be null") @DecimalMin(value = "0.0", inclusive = true, message = "Gross pay must be 0 or greater.") double netPay,
			@NotNull(message = "Benifits cannot be null") @DecimalMin(value = "0.0", inclusive = true, message = "Benefits must be 0 or greater.") double benefits,
			@NotNull(message = "Deductions cannot be null") @DecimalMin(value = "0.0", inclusive = true, message = "Deductions must be 0 or greater.") double deductions,
			LocalDate startDate, LocalDate endDate,
			@NotNull(message = "Payroll date must not be null.") @PastOrPresent(message = "Payroll date cannot be in the future.") LocalDate payrollDate) {
		super();
		this.payrollId = payrollId;
		this.employee = employee;
		this.grossPay = grossPay;
		this.netPay = netPay;
		this.benefits = benefits;
		this.deductions = deductions;
		this.startDate = startDate;
		this.endDate = endDate;
		this.payrollDate = payrollDate;
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
		return grossPay;
	}

	public void setGrosspay(double grossPay) {
		this.grossPay = grossPay;
	}

	public double getBenefits() {
		return benefits;
	}

	public void setBenifits(double benefits) {
		this.benefits = benefits;
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


	public double getNetPay() {
		return netPay;
	}



	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}



	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", employee=" + employee + ", grossPay=" + grossPay + ", netPay="
				+ netPay + ", benefits=" + benefits + ", deductions=" + deductions + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", payrollDate=" + payrollDate + "]";
	}



	


	
	
	
	
	
	
}
