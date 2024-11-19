package com.hexaware.easyspay.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.entities.ComplianceReport;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.PayrollPolicy;
import com.hexaware.easyspay.entities.User;
import com.hexaware.easyspay.repository.ComplianceReportRepository;
import com.hexaware.easyspay.repository.EmployeeRepository;
import com.hexaware.easyspay.repository.PayrollPolicyRepository;
import com.hexaware.easyspay.repository.UserRepository;

@Service
public class AdminHrManagerServiceImp implements IAdminHrManagerService {

    @Autowired
    private EmployeeRepository employeeRepo;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private PayrollPolicyRepository payrollPolicyRepo;
    
    @Autowired
    private ComplianceReportRepository complianceReportRepo;

    
    
    // Employee Management
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
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
    public User updateUser(User user) {
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
    public PayrollPolicy updatePayrollPolicy(PayrollPolicy policy) {
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
    public ComplianceReport updateComplianceReport(ComplianceReport report) {
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
