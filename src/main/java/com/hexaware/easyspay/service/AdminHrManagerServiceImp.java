package com.hexaware.easyspay.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.dto.EmployeeDto;
import com.hexaware.easyspay.entities.Benefits;
import com.hexaware.easyspay.entities.ComplianceReport;
import com.hexaware.easyspay.entities.Deductions;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.PayrollPolicy;
import com.hexaware.easyspay.entities.Role;
import com.hexaware.easyspay.entities.User;
import com.hexaware.easyspay.exceptions.EmployeeNotFoundException;
import com.hexaware.easyspay.repository.IBenefitsRepository;
import com.hexaware.easyspay.repository.IComplianceReportRepository;
import com.hexaware.easyspay.repository.IDeductionsRepository;
import com.hexaware.easyspay.repository.IEmployeeRepository;
import com.hexaware.easyspay.repository.IPayrollPolicyRepository;
import com.hexaware.easyspay.repository.IRoleRepository;
import com.hexaware.easyspay.repository.IUserRepository;

@Service
public class AdminHrManagerServiceImp implements IAdminHrManagerService {

    @Autowired
    private IEmployeeRepository employeeRepo;
    
    @Autowired
    private IUserRepository userRepo;
    
    @Autowired
    private IPayrollPolicyRepository payrollPolicyRepo;
    
    @Autowired
    private IComplianceReportRepository complianceReportRepo;
    
    @Autowired
    private IDeductionsRepository deductionsRepo;
    
    @Autowired
    private IBenefitsRepository benefitsRepo;
    
    @Autowired
    private IRoleRepository  roleRepo;

    
    
    // Employee Management
    @Override
    public Employee addEmployee(EmployeeDto employeeDto) {
    	
    	
    	   User user = userRepo.findById(employeeDto.getUserId())
    	            .orElseThrow(() -> new RuntimeException("User not found with ID: " + employeeDto.getUserId()));
    	    
    	   Deductions deductions = deductionsRepo.findById(employeeDto.getDeductionId())
    	            .orElseThrow(() -> new RuntimeException("Deductions not found with ID: " + employeeDto.getDeductionId()));
    	    
    	   Benefits benefits = benefitsRepo.findById(employeeDto.getBenefitId())
    	            .orElseThrow(() -> new RuntimeException("Benefits not found with ID: " + employeeDto.getBenefitId()));
    	    
    	   Role role = roleRepo.findById(employeeDto.getRoleId())
    	            .orElseThrow(() -> new RuntimeException("Role not found with ID: " + employeeDto.getRoleId()));

    	
        Employee employee = new Employee();
        employee.setEmpName(employeeDto.getEmpName());
        employee.setPosition(employeeDto.getPosition());
        employee.setEmpDepartment(employeeDto.getEmpDepartment());
        employee.setEmpsalary(employeeDto.getEmpsalary());
        employee.setJoinDate(employeeDto.getJoinDate());
        employee.setUser(user);
        employee.setDeductions(deductions);
        employee.setBenefits(benefits);
        employee.setRole(role);
        
        if (employeeDto.getManagerId() != null) {
            Employee manager = employeeRepo.findById(employeeDto.getManagerId())
                    .orElseThrow(() -> new RuntimeException("Manager not found"));
            employee.setManager(manager);
        }


    	
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(int empId ,EmployeeDto employeeDto) {
    	
        Employee employee = employeeRepo.findById(empId)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee with Id: "+empId+" not found"));
        // Fetch the existing Employee
        Employee existingEmployee = employeeRepo.findById(employeeDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeDto.getUserId()));

        // Fetch related entities if provided in the DTO
        if (employeeDto.getDeductionId() != 0) {
            Deductions deductions = deductionsRepo.findById(employeeDto.getDeductionId())
                    .orElseThrow(() -> new RuntimeException("Deductions not found with ID: " + employeeDto.getDeductionId()));
            existingEmployee.setDeductions(deductions);
        }

        if (employeeDto.getBenefitId() != 0) {
            Benefits benefits = benefitsRepo.findById(employeeDto.getBenefitId())
                    .orElseThrow(() -> new RuntimeException("Benefits not found with ID: " + employeeDto.getBenefitId()));
            existingEmployee.setBenefits(benefits);
        }

        if (employeeDto.getRoleId() != 0) {
            Role role = roleRepo.findById(employeeDto.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found with ID: " + employeeDto.getRoleId()));
            existingEmployee.setRole(role);
        }

        Employee manager = null;
        
        if (employeeDto.getManagerId() != null) {
            manager = employeeRepo.findById(employeeDto.getManagerId())
                    .orElseThrow(() -> new RuntimeException("Manager not found with ID: " + employeeDto.getManagerId()));
            existingEmployee.setManager(manager);
        }

        // Update other fields
        existingEmployee.setEmpName(employeeDto.getEmpName());
        existingEmployee.setPosition(employeeDto.getPosition());
        existingEmployee.setEmpDepartment(employeeDto.getEmpDepartment());
        existingEmployee.setEmpsalary(employeeDto.getEmpsalary());
        existingEmployee.setJoinDate(employeeDto.getJoinDate());
        existingEmployee.setManager(manager);

        // Save the updated employee
        return employeeRepo.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(int empId) {
        employeeRepo.deleteById(empId);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeRepo.findById(empId).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    
    
    // User Management
    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(int userId ,User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public User getUserById(int userId) {
        return userRepo.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Payroll Policy Management
    @Override
    public PayrollPolicy addPayrollPolicy(PayrollPolicy policy) {
        return payrollPolicyRepo.save(policy);
    }

    @Override
    public PayrollPolicy updatePayrollPolicy(int policyId,PayrollPolicy policy) {
        return payrollPolicyRepo.save(policy);
    }

    @Override
    public void deletePayrollPolicy(int policyId) {
        payrollPolicyRepo.deleteById(policyId);
    }

    @Override
    public PayrollPolicy getPayrollPolicyById(int policyId) {
        return payrollPolicyRepo.findById(policyId).orElse(null);
    }

    @Override
    public List<PayrollPolicy> getAllPayrollPolicies() {
        return payrollPolicyRepo.findAll();
    }



    // Compliance Reporting
    @Override
    public ComplianceReport addComplianceReport(ComplianceReport report) {
        return complianceReportRepo.save(report);
    }

    @Override
    public ComplianceReport updateComplianceReport(int reportId,ComplianceReport report) {
        return complianceReportRepo.save(report);
    }

    @Override
    public void deleteComplianceReport(int reportId) {
        complianceReportRepo.deleteById(reportId);
    }

    @Override
    public ComplianceReport getComplianceReportById(int reportId) {
        return complianceReportRepo.findById(reportId).orElse(null);
    }

    @Override
    public List<ComplianceReport> getAllComplianceReports() {
        return complianceReportRepo.findAll();
    }
}
