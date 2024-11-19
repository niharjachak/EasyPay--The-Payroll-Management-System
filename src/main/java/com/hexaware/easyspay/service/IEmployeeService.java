package com.hexaware.easyspay.service;


import java.util.List;

import com.hexaware.easyspay.entities.Attendance;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;

public interface IEmployeeService {

	Employee updatePersonalInformation(int employeeId, Employee updatedInfo);

    List<Payroll> getPayStubs(int employeeId);

    Attendance submitAttendance(int employeeId, Attendance attendance);

    Leaves requestLeave(int employeeId, Leaves leaveRequest);

}
