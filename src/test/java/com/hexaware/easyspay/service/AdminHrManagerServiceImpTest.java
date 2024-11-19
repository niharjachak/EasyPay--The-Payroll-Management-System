package com.hexaware.easyspay.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.User;
import com.hexaware.easyspay.entities.PayrollPolicy;
import com.hexaware.easyspay.entities.ComplianceReport;

import java.time.LocalDate;
import java.util.List;

class AdminHrManagerServiceImpTest {

    @Autowired
    private AdminHrManagerServiceImp adminHrManagerService;



    @Test
    void testAddEmployee() {
        Employee employee = new Employee();
        employee.setEmpName("Jane Doe");
        employee.setPosition("HR Manager");
        employee.setEmpDepartment("HR");
        employee.setEmpsalary(60000.00);
        employee.setJoinDate(java.sql.Date.valueOf("2023-02-01"));

        Employee addedEmployee = adminHrManagerService.addEmployee(employee);

        assertNotNull(addedEmployee);
        assertEquals("Jane Doe", addedEmployee.getEmpName());
        assertTrue(addedEmployee.getEmpId() > 0); 
    }

    @Test
    void testUpdateEmployee() {
        Employee employee = adminHrManagerService.getEmployeeById(1); 
        employee.setEmpName("John Doe Updated");
        Employee updatedEmployee = adminHrManagerService.updateEmployee(employee);

        assertNotNull(updatedEmployee);
        assertEquals("John Doe Updated", updatedEmployee.getEmpName());
    }

    @Test
    void testDeleteEmployee() {
        adminHrManagerService.deleteEmployee(1); 
        Employee employee = adminHrManagerService.getEmployeeById(1); //  get the employee after deletion
        assertNull(employee); // Expecting null since the employee should be deleted
    }

    @Test
    void testGetEmployeeById() {
        Employee employee = adminHrManagerService.getEmployeeById(1); 

        assertNotNull(employee);
        assertEquals(1, employee.getEmpId());
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = adminHrManagerService.getAllEmployees();

        assertFalse(employees.isEmpty()); 
    }

    @Test
    void testAddUser() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("janedoe");
        user.setPassword("password123");
        

        User addedUser = adminHrManagerService.addUser(user);

        assertNotNull(addedUser);
        assertEquals("janedoe", addedUser.getUserName());
    }

    @Test
    void testUpdateUser() {
        User user = adminHrManagerService.getUserById(1); 
        user.setUserName("janedoe_updated");
        User updatedUser = adminHrManagerService.updateUser(user);

        assertNotNull(updatedUser);
        assertEquals("janedoe_updated", updatedUser.getUserName());
    }

    @Test
    void testDeleteUser() {
        adminHrManagerService.deleteUser(1); 


        User deletedUser = adminHrManagerService.getUserById(1);
        assertNull(deletedUser); 
    }

    @Test
    void testGetUserById() {
        User user = adminHrManagerService.getUserById(1);

        assertNotNull(user);
        assertEquals(1, user. getUserId());
    }

    @Test
    void testGetAllUsers() {
        List<User> users = adminHrManagerService.getAllUsers();

        assertFalse(users.isEmpty());
    }

    @Test
    void testAddPayrollPolicy() {
        PayrollPolicy payrollPolicy = new PayrollPolicy();
        payrollPolicy.setPolicyId(10);
        payrollPolicy.setPolicyName("Standard Policy");
        payrollPolicy.setPolicyDesc("Standard Policy desc");
        payrollPolicy.setOvertimeRate(5.5);

        PayrollPolicy addedPayrollPolicy = adminHrManagerService.addPayrollPolicy(payrollPolicy);

        assertNotNull(addedPayrollPolicy);
        assertEquals("Standard Policy", addedPayrollPolicy.getPolicyName());
    }

    @Test
    void testUpdatePayrollPolicy() {
        PayrollPolicy payrollPolicy = adminHrManagerService.getPayrollPolicyById(1); 
        payrollPolicy.setPolicyName("Updated Policy");
        PayrollPolicy updatedPayrollPolicy = adminHrManagerService.updatePayrollPolicy(payrollPolicy);

        assertNotNull(updatedPayrollPolicy);
        assertEquals("Updated Policy", updatedPayrollPolicy.getPolicyName());
    }

    @Test
    void testDeletePayrollPolicy() {


        
        adminHrManagerService.deletePayrollPolicy(1);


        PayrollPolicy deletedPolicy = adminHrManagerService.getPayrollPolicyById(1);
        assertNull(deletedPolicy);  
    }


    @Test
    void testGetPayrollPolicyById() {
        PayrollPolicy payrollPolicy = adminHrManagerService.getPayrollPolicyById(1); // Assuming policy with ID 1 exists

        assertNotNull(payrollPolicy);
        assertEquals(1, payrollPolicy.getPolicyId());
    }

    @Test
    void testGetAllPayrollPolicies() {
        List<PayrollPolicy> payrollPolicies = adminHrManagerService.getAllPayrollPolicies();

        assertFalse(payrollPolicies.isEmpty()); 
    }

    @Test
    void testAddComplianceReport() {
        ComplianceReport complianceReport = new ComplianceReport();
        complianceReport.setReportId(20);
        complianceReport.setReportDate(LocalDate.now()); 
        complianceReport.setComplianceStatus("Annual Report");

        ComplianceReport addedReport = adminHrManagerService.addComplianceReport(complianceReport);

        assertNotNull(addedReport);
        assertEquals(20, addedReport.getReportId());
       
    }



    
    @Test
    void testUpdateComplianceReport() {
        
        ComplianceReport complianceReport = adminHrManagerService.getComplianceReportById(1);
        complianceReport.setComplianceStatus("Updated Report");
        ComplianceReport updatedReport = adminHrManagerService.updateComplianceReport(complianceReport);

       
        assertNotNull(updatedReport);
        assertEquals("Updated Report", updatedReport.getComplianceStatus()); 
    }


    @Test
    void testDeleteComplianceReport() {
        adminHrManagerService.deleteComplianceReport(1); 
        ComplianceReport report = adminHrManagerService.getComplianceReportById(1);
        assertNull(report); 
    }


    @Test
    void testgetComplianceReportById() {
        ComplianceReport complianceReport = adminHrManagerService.getComplianceReportById(1); // Assuming report with ID 1 exists

        assertNotNull(complianceReport);
        assertEquals(1, complianceReport.getReportId());
    }

    @Test
    void testGetAllComplianceReports() {
        List<ComplianceReport> complianceReports = adminHrManagerService.getAllComplianceReports();

        assertFalse(complianceReports.isEmpty()); 
    }
}
