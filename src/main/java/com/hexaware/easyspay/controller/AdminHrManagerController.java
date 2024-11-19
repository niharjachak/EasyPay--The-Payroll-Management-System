package com.hexaware.easyspay.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.easyspay.entities.ComplianceReport;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.PayrollPolicy;
import com.hexaware.easyspay.entities.User;
import com.hexaware.easyspay.exception.ComplianceReportNotFoundException;
import com.hexaware.easyspay.exception.EmployeeNotFoundException;
import com.hexaware.easyspay.exception.PayrollPolicyNotFoundException;
import com.hexaware.easyspay.exception.UserNotFoundException;
import com.hexaware.easyspay.service.IAdminHrManagerService;

@RestController
@RequestMapping("/api/adminhr")
public class AdminHrManagerController {

     Logger logger = LoggerFactory.getLogger(AdminHrManagerController.class);

    @Autowired
    private IAdminHrManagerService service;

    // Employee Management
    @PostMapping("/employee/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        logger.info("Adding a new employee: {}", employee);
        Employee addedEmployee = service.addEmployee(employee);
        logger.info("Employee added successfully: {}", addedEmployee);
        return addedEmployee;
    }

    @PutMapping("/employee/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        logger.info("Updating employee with ID: {}", employee.getEmpId());
        if (service.getEmployeeById(employee.getEmpId()) == null) {
            logger.error("Employee with ID {} not found.", employee.getEmpId());
            throw new EmployeeNotFoundException("Employee with ID " + employee.getEmpId() + " not found.");
        }
        Employee updatedEmployee = service.updateEmployee(employee);
        logger.info("Employee updated successfully: {}", updatedEmployee);
        return updatedEmployee;
    }

    @DeleteMapping("/employee/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId) {
        logger.info("Deleting employee with ID: {}", empId);
        if (service.getEmployeeById(empId) == null) {
            logger.error("Employee with ID {} not found.", empId);
            throw new EmployeeNotFoundException("Employee with ID " + empId + " not found.");
        }
        service.deleteEmployee(empId);
        logger.info("Employee with ID {} deleted successfully.", empId);
        return "Employee with ID " + empId + " deleted successfully.";
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployeeById(@PathVariable int empId) {
        logger.info("Fetching employee with ID: {}", empId);
        Employee employee = service.getEmployeeById(empId);
        if (employee == null) {
            logger.error("Employee with ID {} not found.", empId);
            throw new EmployeeNotFoundException("Employee with ID " + empId + " not found.");
        }
        logger.info("Employee fetched successfully: {}", employee);
        return employee;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees.");
        List<Employee> employees = service.getAllEmployees();
        logger.info("Total employees fetched: {}", employees.size());
        return employees;
    }

    // User Management
    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        logger.info("Adding a new user: {}", user);
        User addedUser = service.addUser(user);
        logger.info("User added successfully: {}", addedUser);
        return addedUser;
    }

    @PutMapping("/user/update")
    public User updateUser(@RequestBody User user) {
        logger.info("Updating user with ID: {}", user.getUserId());
        if (service.getUserById(user.getUserId()) == null) {
            logger.error("User with ID {} not found.", user.getUserId());
            throw new UserNotFoundException("User with ID " + user.getUserId() + " not found.");
        }
        User updatedUser = service.updateUser(user);
        logger.info("User updated successfully: {}", updatedUser);
        return updatedUser;
    }

    @DeleteMapping("/user/delete/{userId}")
    public String deleteUser(@PathVariable int userId) {
        logger.info("Deleting user with ID: {}", userId);
        if (service.getUserById(userId) == null) {
            logger.error("User with ID {} not found.", userId);
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
        service.deleteUser(userId);
        logger.info("User with ID {} deleted successfully.", userId);
        return "User with ID " + userId + " deleted successfully.";
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable int userId) {
        logger.info("Fetching user with ID: {}", userId);
        User user = service.getUserById(userId);
        if (user == null) {
            logger.error("User with ID {} not found.", userId);
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
        logger.info("User fetched successfully: {}", user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        logger.info("Fetching all users.");
        List<User> users = service.getAllUsers();
        logger.info("Total users fetched: {}", users.size());
        return users;
    }

    // Payroll Policy Management
    @PostMapping("/payrollPolicy/add")
    public PayrollPolicy addPayrollPolicy(@RequestBody PayrollPolicy policy) {
        logger.info("Adding a new payroll policy: {}", policy);
        PayrollPolicy addedPolicy = service.addPayrollPolicy(policy);
        logger.info("Payroll policy added successfully: {}", addedPolicy);
        return addedPolicy;
    }

    @PutMapping("/payrollPolicy/update")
    public PayrollPolicy updatePayrollPolicy(@RequestBody PayrollPolicy policy) {
        logger.info("Updating payroll policy with ID: {}", policy.getPolicyId());
        if (service.getPayrollPolicyById(policy.getPolicyId()) == null) {
            logger.error("Payroll policy with ID {} not found.", policy.getPolicyId());
            throw new PayrollPolicyNotFoundException("Payroll policy with ID " + policy.getPolicyId() + " not found.");
        }
        PayrollPolicy updatedPolicy = service.updatePayrollPolicy(policy);
        logger.info("Payroll policy updated successfully: {}", updatedPolicy);
        return updatedPolicy;
    }

    @DeleteMapping("/payrollPolicy/delete/{policyId}")
    public String deletePayrollPolicy(@PathVariable int policyId) {
        logger.info("Deleting payroll policy with ID: {}", policyId);
        if (service.getPayrollPolicyById(policyId) == null) {
            logger.error("Payroll policy with ID {} not found.", policyId);
            throw new PayrollPolicyNotFoundException("Payroll policy with ID " + policyId + " not found.");
        }
        service.deletePayrollPolicy(policyId);
        logger.info("Payroll policy with ID {} deleted successfully.", policyId);
        return "Payroll policy with ID " + policyId + " deleted successfully.";
    }

    @GetMapping("/payrollPolicy/{policyId}")
    public PayrollPolicy getPayrollPolicyById(@PathVariable int policyId) {
        logger.info("Fetching payroll policy with ID: {}", policyId);
        PayrollPolicy policy = service.getPayrollPolicyById(policyId);
        if (policy == null) {
            logger.error("Payroll policy with ID {} not found.", policyId);
            throw new PayrollPolicyNotFoundException("Payroll policy with ID " + policyId + " not found.");
        }
        logger.info("Payroll policy fetched successfully: {}", policy);
        return policy;
    }

    @GetMapping("/payrollPolicies")
    public List<PayrollPolicy> getAllPayrollPolicies() {
        logger.info("Fetching all payroll policies.");
        List<PayrollPolicy> policies = service.getAllPayrollPolicies();
        logger.info("Total payroll policies fetched: {}", policies.size());
        return policies;
    }

    // Compliance Reporting
    @PostMapping("/complianceReport/add")
    public ComplianceReport addComplianceReport(@RequestBody ComplianceReport report) {
        logger.info("Adding a new compliance report: {}", report);
        ComplianceReport addedReport = service.addComplianceReport(report);
        logger.info("Compliance report added successfully: {}", addedReport);
        return addedReport;
    }

    @PutMapping("/complianceReport/update")
    public ComplianceReport updateComplianceReport(@RequestBody ComplianceReport report) {
        logger.info("Updating compliance report with ID: {}", report.getReportId());
        if (service.getComplianceReportById(report.getReportId()) == null) {
            logger.error("Compliance report with ID {} not found.", report.getReportId());
            throw new ComplianceReportNotFoundException("Compliance report with ID " + report.getReportId() + " not found.");
        }
        ComplianceReport updatedReport = service.updateComplianceReport(report);
        logger.info("Compliance report updated successfully: {}", updatedReport);
        return updatedReport;
    }

    @DeleteMapping("/complianceReport/delete/{reportId}")
    public String deleteComplianceReport(@PathVariable int reportId) {
        logger.info("Deleting compliance report with ID: {}", reportId);
        if (service.getComplianceReportById(reportId) == null) {
            logger.error("Compliance report with ID {} not found.", reportId);
            throw new ComplianceReportNotFoundException("Compliance report with ID " + reportId + " not found.");
        }
        service.deleteComplianceReport(reportId);
        logger.info("Compliance report with ID {} deleted successfully.", reportId);
        return "Compliance report with ID " + reportId + " deleted successfully.";
    }

    @GetMapping("/complianceReport/{reportId}")
    public ComplianceReport getComplianceReportById(@PathVariable int reportId) {
        logger.info("Fetching compliance report with ID: {}", reportId);
        ComplianceReport report = service.getComplianceReportById(reportId);
        if (report == null) {
            logger.error("Compliance report with ID {} not found.", reportId);
            throw new ComplianceReportNotFoundException("Compliance report with ID " + reportId + " not found.");
        }
        logger.info("Compliance report fetched successfully: {}", report);
        return report;
    }

    @GetMapping("/complianceReports")
    public List<ComplianceReport> getAllComplianceReports() {
        logger.info("Fetching all compliance reports.");
        List<ComplianceReport> reports = service.getAllComplianceReports();
        logger.info("Total compliance reports fetched: {}", reports.size());
        return reports;
    }
}
