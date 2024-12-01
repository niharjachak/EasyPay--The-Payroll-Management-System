package com.hexaware.easyspay.service;

import java.util.List;

import com.hexaware.easyspay.dto.EmployeeDto;
import com.hexaware.easyspay.entities.ComplianceReport;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.PayrollPolicy;
import com.hexaware.easyspay.entities.User;
import com.hexaware.easyspay.exceptions.ComplianceReportNotFoundException;
import com.hexaware.easyspay.exceptions.EmployeeNotFoundException;
import com.hexaware.easyspay.exceptions.PayrollPolicyNotFoundException;
import com.hexaware.easyspay.exceptions.UserNotFoundException;

public interface IAdminHrManagerService {

    // Employee Management
    Employee addEmployee(EmployeeDto employee);
    Employee updateEmployee(int empId,EmployeeDto employeeDto);
    void deleteEmployee(int empId) throws EmployeeNotFoundException;
    Employee getEmployeeById(int empId) throws EmployeeNotFoundException;
    List<Employee> getAllEmployees()throws EmployeeNotFoundException;

    // User Management
    User addUser(User user);
    User updateUser(int userId,User user)throws UserNotFoundException;;
    void deleteUser(int userId) throws UserNotFoundException;
    User getUserById(int userId) throws UserNotFoundException;
    List<User> getAllUsers()throws UserNotFoundException;;

    // Payroll Policy Management
    PayrollPolicy addPayrollPolicy(PayrollPolicy policy);
    PayrollPolicy updatePayrollPolicy(int policyId,PayrollPolicy policy)throws PayrollPolicyNotFoundException;
    void deletePayrollPolicy(int policyId) throws PayrollPolicyNotFoundException;
    PayrollPolicy getPayrollPolicyById(int policyId) throws PayrollPolicyNotFoundException;
    List<PayrollPolicy> getAllPayrollPolicies()throws PayrollPolicyNotFoundException;

    // Compliance Reporting
    ComplianceReport addComplianceReport(ComplianceReport report);
    ComplianceReport updateComplianceReport(int reportId,ComplianceReport report);
    void deleteComplianceReport(int reportId) throws ComplianceReportNotFoundException;
    ComplianceReport getComplianceReportById(int reportId) throws ComplianceReportNotFoundException;
    List<ComplianceReport> getAllComplianceReports();
}
