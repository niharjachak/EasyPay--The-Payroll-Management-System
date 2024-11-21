package com.hexaware.easyspay.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name ="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@Size(max = 50)
	@NotBlank(message= "Employee name Should not be blank")
	private String empName;
	
	@NotBlank(message= "Employee position Should not be blank")
	private String position;
	
	@NotBlank(message= "Employee department Should not be blank")
	private String empDepartment;
	
	@NotNull
	private double empsalary;
	
	
	private LocalDate joinDate;
	
	@OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Payroll> payrolls;
	

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<ComplianceReport> complianceReports;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Leaves> leaves;

    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Attendance> attendances;

    
    //Role is missing in my entity class
    
    
    
  
    
    @ManyToOne
	@JoinColumn(name= "manager_id")
	private Employee manager;
    
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Deductions> deductions;
    
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Benefits> benefits;

	
	public Employee() {
		super();
	}
	
	
	
	
	

	public Employee(int empId, @Size(max = 50) @NotBlank(message = "Employee name Should not be blank") String empName,
			@NotBlank(message = "Employee position Should not be blank") String position,
			@NotBlank(message = "Employee department Should not be blank") String empDepartment,
			@NotNull double empsalary, LocalDate joinDate, User user,List<ComplianceReport> complianceReports, List<Benefits> benefits, List<Deductions> deductions,
			Employee manager, List<Payroll> payrolls, List<Leaves> leaves, List<Attendance> attendances) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.position = position;
		this.empDepartment = empDepartment;
		this.empsalary = empsalary;
		this.joinDate = joinDate;
		this.user = user;
		
		this.complianceReports = complianceReports;
		this.benefits = benefits;
		this.deductions = deductions;
		this.manager = manager;
		this.payrolls = payrolls;
		this.leaves = leaves;
		this.attendances = attendances;
	}
	




	public List<ComplianceReport> getComplianceReports() {
		return complianceReports;
	}





	public void setComplianceReports(List<ComplianceReport> complianceReports) {
		this.complianceReports = complianceReports;
	}





	public List<Benefits> getBenefits() {
		return benefits;
	}





	public void setBenefits(List<Benefits> benefits) {
		this.benefits = benefits;
	}





	public List<Deductions> getDeductions() {
		return deductions;
	}





	public void setDeductions(List<Deductions> deductions) {
		this.deductions = deductions;
	}





	public int getEmpId() {
		return empId;
	}



	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getPosition() {
		return position;
	}






	public String getEmpName() {
		return empName;
	}




	public void setEmpName(String employeeName) {
		this.empName = employeeName;
	}




	public List<Payroll> getPayrolls() {
		return payrolls;
	}




	public void setPayrolls(List<Payroll> payrolls) {
		this.payrolls = payrolls;
	}




	public List<Leaves> getLeaves() {
		return leaves;
	}




	public void setLeaves(List<Leaves> leaves) {
		this.leaves = leaves;
	}




	public List<Attendance> getAttendances() {
		return attendances;
	}




	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}




	public void setPosition(String position) {
		this.position = position;
	}


	public String getEmpDepartment() {
		return empDepartment;
	}


	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}


	public double getEmpsalary() {
		return empsalary;
	}


	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}


	public LocalDate getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}


	public User getUser() {
		return user;
	}


	public void setUserId(User user) {
		this.user = user;
	}


	public Employee getManager() {
		return manager;
	}


	public void setManager(Employee manager) {
		this.manager = manager;
	}





	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", position=" + position + ", empDepartment="
				+ empDepartment + ", empsalary=" + empsalary + ", joinDate=" + joinDate + ", user=" + user
				+  ", complianceReports=" + complianceReports + ", benefits=" + benefits
				+ ", deductions=" + deductions + ", manager=" + manager + ", payrolls=" + payrolls + ", leaves="
				+ leaves + ", attendances=" + attendances + "]";
	}


	
	
		
	
	
	

}
