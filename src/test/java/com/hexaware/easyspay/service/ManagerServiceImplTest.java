package com.hexaware.easyspay.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.repository.ILeavesRepository;
import com.hexaware.easyspay.repository.IPayrollRepository;

class ManagerServiceImplTest {
	
	@Mock
	private IPayrollRepository payrollrepo;
	
	@Mock
	private ILeavesRepository leavesrepo;
	
	@InjectMocks
	private ManagerServiceImpl managerService;
	
	
	@BeforeEach
	void setUp() {
		
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testReviewTeamPayrolls() {
		 // Mock data setup
        int managerId = 101;

        // Create a mock manager
        Employee manager = new Employee();
        manager.setEmpId(managerId);
        manager.setEmpName("Manager Name");

        // Create mock employees under the manager
        Employee emp1 = new Employee();
        emp1.setEmpId(1);
        emp1.setEmpName("Employee One");
        emp1.setManager(manager);

        Employee emp2 = new Employee();
        emp2.setEmpId(2);
        emp2.setEmpName("Employee Two");
        emp2.setManager(manager);

        // Create mock payrolls for the employees
        Payroll payroll1 = new Payroll();
        payroll1.setPayrollId(1);
        payroll1.setEmployee(emp1);
        payroll1.setGrosspay(5000);
        payroll1.setDeductions(300);
        payroll1.setBenifits(200);
        payroll1.setPayrollDate(LocalDate.now());

        Payroll payroll2 = new Payroll();
        payroll2.setPayrollId(2);
        payroll2.setEmployee(emp2);
        payroll2.setGrosspay(6000);
        payroll2.setDeductions(400);
        payroll2.setBenifits(300);
        payroll2.setPayrollDate(LocalDate.now());

        // Mock repository behavior
        when(payrollrepo.findByEmployeeManagerEmpId(managerId)).thenReturn(Arrays.asList(payroll1, payroll2));

        // Test the service method
        List<Payroll> result = managerService.reviewTeamPayrolls(managerId);

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(5000, result.get(0).getGrosspay());
        assertEquals(6000, result.get(1).getGrosspay());
        verify(payrollrepo, times(1)).findByEmployeeManagerEmpId(managerId);
    }
	

	@Test
	void testApproveLeaveRequest() {
		
		int managerId= 101;
		int leaveId = 10;
		Leaves leaveRequest = new Leaves(leaveId, null, null, null ,"Vacation","Pending",null);
		
		
		when(leavesrepo.findById(leaveId)).thenReturn(Optional.of(leaveRequest));
		when (leavesrepo.save(any(Leaves.class))).thenReturn(leaveRequest);
		
		
		Leaves result= managerService.approveLeaveRequest(managerId, leaveId, "Approved");
		
		assertNotNull(result);
		assertEquals("Approved",result.getLeaveStatus());
		verify(leavesrepo, times(1)).findById(leaveId);
        verify(leavesrepo, times(1)).save(any(Leaves.class));
	
		
		
	}

}
