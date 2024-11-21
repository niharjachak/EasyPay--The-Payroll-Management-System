package com.hexaware.easyspay.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.exceptions.LeavesRequestException;
import com.hexaware.easyspay.exceptions.PayrollNotFoundException;
import com.hexaware.easyspay.exceptions.UnAuthorizedActionException;
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
        List<Payroll> payrolls =  payrollRepository.findByEmployeeManagerEmpId(managerId);
        if (payrolls.isEmpty()) {
            throw new PayrollNotFoundException("No payroll records found for manager with ID " + managerId);
        }

        return payrolls;
    }

    @Override
    public Leaves approveLeaveRequest(int managerId, int leaveId, String status) {
        
        Leaves leavesRequest = leaveRequestRepository.findById(leaveId)
        		.orElseThrow(()-> new LeavesRequestException("Leave request with ID " + leaveId + " not found"));
        
        // Check if the manager is authorized
        if (leavesRequest.getManager() == null || leavesRequest.getManager().getEmpId() != managerId) {
            throw new UnAuthorizedActionException("Manager with ID " + managerId + " is not authorized to approve/reject this leave request");
        }
        
        leavesRequest.setLeaveStatus(status);
        
        return leaveRequestRepository.save(leavesRequest);
    }

	

}
