package com.hexaware.easyspay.service;

import java.util.List;


import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;

public interface IManagerService {

	List<Payroll> reviewTeamPayrolls(int managerId);

    Leaves approveLeaveRequest(int managerId, int leaveId, String status);
}
