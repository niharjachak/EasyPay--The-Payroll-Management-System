package com.hexaware.easyspay.service;



import java.util.List;

import com.hexaware.easyspay.entities.ComplianceReport;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.PayrollPolicy;
import com.hexaware.easyspay.entities.User;

public interface IAdminHrManagerService {

    // Employee Management
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(int empId);
    Employee getEmployeeById(int empId);
    List<Employee> getAllEmployees();

    // User Management
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(int userId);
    User getUserById(int userId);
    List<User> getAllUsers();

    // Payroll Policy Management
    PayrollPolicy addPayrollPolicy(PayrollPolicy policy);
    PayrollPolicy updatePayrollPolicy(PayrollPolicy policy);
    void deletePayrollPolicy(int policyId);
    PayrollPolicy getPayrollPolicyById(int policyId);
    List<PayrollPolicy> getAllPayrollPolicies();



    // Compliance Reporting
    ComplianceReport addComplianceReport(ComplianceReport report);
    ComplianceReport updateComplianceReport(ComplianceReport report);
    void deleteComplianceReport(int reportId);
    ComplianceReport getComplianceReportById(int reportId);
    List<ComplianceReport> getAllComplianceReports();
}
