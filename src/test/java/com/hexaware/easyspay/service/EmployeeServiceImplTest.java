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
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.easyspay.entities.Attendance;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.repository.IAttendanceRepository;
import com.hexaware.easyspay.repository.IEmployeeRepository;
import com.hexaware.easyspay.repository.ILeavesRepository;
import com.hexaware.easyspay.repository.IPayrollRepository;

@SpringBootTest
class EmployeeServiceImplTest {
	
	@Mock
	private IEmployeeRepository employeerepo;
	
	@Mock
	private IPayrollRepository payrollrepo;
	
	@Mock
	private IAttendanceRepository attendancerepo;
	
	@Mock
	private ILeavesRepository leavesrepo;
	
	
	@InjectMocks
	private EmployeeServiceImpl empservice;
	
	@BeforeEach
	void setUp(){
		
		MockitoAnnotations.openMocks(this);
	}
	
	
	

	@Test
	void testUpdatePersonalInformation() {

		int empId =101;
		// Mock existing employee
        Employee existingEmployee = new Employee(empId, "John", "Engineer", "IT", 50000, LocalDate.now(), null, null, null, null, null, null, null, null);
        Employee updatedEmployee = new Employee(empId, "John Doe", "Senior Engineer", "IT", 70000, LocalDate.now(), null, null, null, null, null, null, null, null);
        
        when(employeerepo.findById(empId)).thenReturn(Optional.of(existingEmployee));
        when(employeerepo.save(any(Employee.class))).thenReturn(updatedEmployee);
        
        Employee result = empservice.updatePersonalInformation(empId, updatedEmployee);

        // Assertions
        assertNotNull(result);
        assertEquals("John Doe", result.getEmpName());
        assertEquals("Senior Engineer", result.getPosition());
        assertEquals(70000, result.getEmpsalary());
        verify(employeerepo, times(1)).findById(empId);
        verify(employeerepo, times(1)).save(any(Employee.class));
        
	}

	@Test
	void testGetPayStubs() {
		int empId = 102;

        // Mock payroll data
        Payroll payroll1 = new Payroll(1, null, 5000, 200,4500, 300, LocalDate.now(), LocalDate.now(), LocalDate.now().plusMonths(1));
        Payroll payroll2 = new Payroll(2, null, 6000, 300, 4500,400, LocalDate.now(), LocalDate.now(), LocalDate.now().plusMonths(1));

        when(payrollrepo.findByEmployeeEmpId(empId)).thenReturn(Arrays.asList(payroll1, payroll2));

        List<Payroll> payrolls = empservice.getPayStubs(empId);

        // Assertions
        assertNotNull(payrolls);
        assertEquals(2, payrolls.size());
        assertEquals(5000, payrolls.get(0).getGrosspay());
        assertEquals(6000, payrolls.get(1).getGrosspay());
        verify(payrollrepo, times(1)).findByEmployeeEmpId(empId);
	}

	@Test
	void testSubmitAttendance() {
		int empId = 104;

        // Mock employee
        Employee employee = new Employee(empId, "John", "Engineer", "IT", 50000, LocalDate.now(), null, null, null, null, null, null, null, null);
        Attendance attendance = new Attendance(1, employee, LocalDate.now(), 8, "Present");

        when(employeerepo.findById(empId)).thenReturn(Optional.of(employee));
        when(attendancerepo.save(any(Attendance.class))).thenReturn(attendance);

        Attendance result = empservice.submitAttendance(empId, attendance);

        // Assertions
        assertNotNull(result);
        assertEquals(8, result.getHoursWorked());
        assertEquals("Present", result.getAttendanceStatus());
        verify(employeerepo, times(1)).findById(empId);
        verify(attendancerepo, times(1)).save(any(Attendance.class));	}

	@Test
	void testRequestLeave() {
		int empId = 107;

        // Mock employee
        Employee employee = new Employee(empId, "John", "Engineer", "IT", 50000, LocalDate.now(), null, null, null, null, null, null, null, null);
        Leaves leaveRequest = new Leaves(1, employee, LocalDate.now(), LocalDate.now().plusDays(5), "Vacation", "Pending", null);

        when(employeerepo.findById(empId)).thenReturn(Optional.of(employee));
        when(leavesrepo.save(any(Leaves.class))).thenReturn(leaveRequest);

        Leaves result = empservice.requestLeave(empId, leaveRequest);

        // Assertions
        assertNotNull(result);
        assertEquals("Vacation", result.getLeaveType());
        assertEquals("Pending", result.getLeaveStatus());
        verify(employeerepo, times(1)).findById(empId);
        verify(leavesrepo, times(1)).save(any(Leaves.class));
    }

}
