package com.hexaware.easyspay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.entities.Attendance;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.repository.IAttendanceRepository;
import com.hexaware.easyspay.repository.IEmployeeRepository;
import com.hexaware.easyspay.repository.ILeavesRepository;
import com.hexaware.easyspay.repository.IPayrollRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	
	
	@Autowired
	private IEmployeeRepository employeeRepository ;
	
	@Autowired
	private IAttendanceRepository attendanceRepository;
	
	@Autowired
	private ILeavesRepository leavesRepository;
	
	@Autowired
	private IPayrollRepository payrollRepository;
	
	
	

	public Employee updatePersonalInformation(int empId, Employee updatedInfo) {
        Employee employee = employeeRepository.findById(empId)
                .orElse(null);
        employee.setEmpName(updatedInfo.getEmpName());
        employee.setEmpDepartment(updatedInfo.getEmpDepartment());
        employee.setPosition(updatedInfo.getPosition());
        employee.setEmpsalary(updatedInfo.getEmpsalary());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Payroll> getPayStubs(int empId) {
        return payrollRepository.findByEmployeeEmpId(empId);
    }

    @Override
    public Attendance submitAttendance(int empId, Attendance attendance) {
        Employee employee = employeeRepository.findById(empId)
                .orElse(null);
        attendance.setEmployee(employee);
        return attendanceRepository.save(attendance);
    }

    @Override
    public Leaves requestLeave(int empId, Leaves leaveRequest) {
        Employee employee = employeeRepository.findById(empId)
                .orElse(null);
        leaveRequest.setEmployee(employee);
        leaveRequest.setLeaveStatus("Pending");
        return leavesRepository.save(leaveRequest);
    }
}

	