package com.hexaware.easyspay.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.repository.ILeavesRepository;
import com.hexaware.easyspay.repository.IPayrollRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements IManagerService {

	@Autowired
    private IPayrollRepository payrollRepository;

    @Autowired
    private ILeavesRepository leaveRequestRepository;

    @Override
    public List<Payroll> reviewTeamPayrolls(int managerId) {
        return payrollRepository.findByEmployeeManagerEmpId(managerId);
    }

    @Override
    public Leaves approveLeaveRequest(int managerId, int leaveId, String status) {
        
        Leaves leavesrequest = leaveRequestRepository.findById(leaveId).orElse(null);
        
        leavesrequest.setLeaveStatus(status);
        
        return leaveRequestRepository.save(leavesrequest);
    }

	

}
