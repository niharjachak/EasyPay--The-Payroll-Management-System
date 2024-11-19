package com.hexaware.easyspay.entities;

import java.sql.Date;
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


@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String position;
    private String empDepartment;
    private double empsalary;
    private Date joinDate; 

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Payroll> payrolls;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<ComplianceReport> complianceReports;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Benefits> benefits;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Deductions> deductions;
    
	 @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	    private List<Leaves> leaves;

	 @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	    private List<Attendance> attendances;


    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    public Employee() {
        super();
    }

    public Employee(int empId, String empName, String position, String empDepartment, double empsalary, Date joinDate,
                    User user, Employee manager) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.position = position;
        this.empDepartment = empDepartment;
        this.empsalary = empsalary;
        this.joinDate = joinDate; 
        this.user = user; 
        this.manager = manager;
    }

   

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPosition() {
        return position;
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

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

	public List<Payroll> getPayrolls() {
		return payrolls;
	}

	public void setPayrolls(List<Payroll> payrolls) {
		this.payrolls = payrolls;
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

    
}
