package com.hexaware.easyspay.service;

import java.util.List;

import com.hexaware.easyspay.entities.ComplianceReport;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.PayrollPolicy;
import com.hexaware.easyspay.entities.User;
import com.hexaware.easyspay.exception.EmployeeNotFoundException;
import com.hexaware.easyspay.exception.UserNotFoundException;
import com.hexaware.easyspay.exception.PayrollPolicyNotFoundException;
import com.hexaware.easyspay.exception.ComplianceReportNotFoundException;

public interface IAdminHrManagerService {

    // Employee Management
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(int empId) throws EmployeeNotFoundException;
    Employee getEmployeeById(int empId) throws EmployeeNotFoundException;
    List<Employee> getAllEmployees()throws EmployeeNotFoundException;

    // User Management
    User addUser(User user);
    User updateUser(User user)throws UserNotFoundException;;
    void deleteUser(int userId) throws UserNotFoundException;
    User getUserById(int userId) throws UserNotFoundException;
    List<User> getAllUsers()throws UserNotFoundException;;

    // Payroll Policy Management
    PayrollPolicy addPayrollPolicy(PayrollPolicy policy);
    PayrollPolicy updatePayrollPolicy(PayrollPolicy policy)throws PayrollPolicyNotFoundException;
    void deletePayrollPolicy(int policyId) throws PayrollPolicyNotFoundException;
    PayrollPolicy getPayrollPolicyById(int policyId) throws PayrollPolicyNotFoundException;
    List<PayrollPolicy> getAllPayrollPolicies()throws PayrollPolicyNotFoundException;

    // Compliance Reporting
    ComplianceReport addComplianceReport(ComplianceReport report);
    ComplianceReport updateComplianceReport(ComplianceReport report);
    void deleteComplianceReport(int reportId) throws ComplianceReportNotFoundException;
    ComplianceReport getComplianceReportById(int reportId) throws ComplianceReportNotFoundException;
    List<ComplianceReport> getAllComplianceReports();
}
