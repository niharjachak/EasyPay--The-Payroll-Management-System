package com.hexaware.easyspay.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.entities.Attendance;
import com.hexaware.easyspay.entities.Benefits;
import com.hexaware.easyspay.entities.Deductions;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.entities.PayrollPolicy;
import com.hexaware.easyspay.exceptions.PayrollNotFoundException;
import com.hexaware.easyspay.repository.IAttendanceRepository;
import com.hexaware.easyspay.repository.IBenefitsRepository;
import com.hexaware.easyspay.repository.IDeductionsRepository;
import com.hexaware.easyspay.repository.IEmployeeRepository;
import com.hexaware.easyspay.repository.IPayrollPolicyRepository;
import com.hexaware.easyspay.repository.IPayrollRepository;

@Service
public class PayrollProcessorServiceImp implements IPayrollProcessorService {

    @Autowired
    private IPayrollRepository payrollRepo;

    @Autowired
    private IPayrollPolicyRepository payrollPolicyRepo;

    @Autowired
    private IBenefitsRepository benefitsRepo;

    @Autowired
    private IDeductionsRepository deductionsRepo;

    @Autowired
    private IEmployeeRepository employeeRepo;

    @Autowired
    private IAttendanceRepository attendanceRepo;

    // Payroll Calculation
    @Override
    public Payroll calculatePayroll(int empId, LocalDate payrollDate) {
        Payroll payroll = new Payroll();
        Employee employee = employeeRepo.findById(empId)
            .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));
        payroll.setEmployee(employee);
        payroll.setPayrollDate(payrollDate);
 
        // Get attendance for the month
        List<Attendance> monthlyAttendance = attendanceRepo.findByEmployeeIdAndMonth(empId, payrollDate.getMonthValue());
        
        // Calculate present days and salary deductions
        int totalDaysInMonth = payrollDate.lengthOfMonth();
        int presentDays = monthlyAttendance.size();
        int absentDays = totalDaysInMonth - presentDays;
        double perDaySalary = employee.getEmpsalary() / totalDaysInMonth;
        double salaryAfterAbsence = employee.getEmpsalary() - (absentDays * perDaySalary);
        
        // Calculate overtime
        double totalOvertimeHours = 0;
        for (Attendance att : monthlyAttendance) {
            if (att.getHoursWorked() > 8) {
                totalOvertimeHours += att.getHoursWorked() - 8;
            }
        }

        PayrollPolicy policy = payrollPolicyRepo.findById(empId)
            .orElseThrow(() -> new RuntimeException("Payroll policy not found for employee ID: " + empId));
        double overtimePay = totalOvertimeHours * policy.getOvertimeRate();
        
        // Fetch benefits using the repository method
        Double benefitAmount = benefitsRepo.findBenefitAmountByEmployeeId(empId);
        
        // If benefitAmount is not null, add it to the payroll
        double totalBenefits = (benefitAmount != null) ? benefitAmount : 0;

        Double totalDeductions = deductionsRepo.findDeductionAmountByEmployeeId(empId);


        

        
        // Set final calculations
        payroll.setGrossPay(salaryAfterAbsence + overtimePay);
        payroll.setBenefits(totalBenefits);
        payroll.setDeductions(totalDeductions);
        payroll.setNetPay(payroll.getGrossPay() + totalBenefits - totalDeductions);
        
        return payroll;
    }
    

    
    @Override
    public boolean verifyPayrollData(Payroll payroll) {
        if (payroll == null) {
            System.out.println("Payroll data is null.");
            return false;
        }

        // Check if Employee exists
        Employee employee = payroll.getEmployee();
        if (employee == null || employeeRepo.findById(employee.getEmpId()).isEmpty()) {
            System.out.println("Employee not found for ID: " + (employee != null ? employee.getEmpId() : "null"));
            return false;
        }

        // Validate gross pay, deductions, and benefits
        if (payroll.getGrossPay() <= 0) {
            System.out.println("Invalid gross pay.");
            return false;
        }
        if (payroll.getDeductions() < 0 || payroll.getBenefits() < 0) {
            System.out.println("Invalid deductions or benefits.");
            return false;
        }

        // Validate payroll date
        if (payroll.getPayrollDate() == null || payroll.getPayrollDate().isAfter(LocalDate.now())) {
            System.out.println("Invalid payroll date.");
            return false;
        }

        System.out.println("Payroll data verification successful for Employee ID: " + payroll.getEmployee().getEmpId());
        return true;
    }
    
    // Benefits Management
    @Override
    public Benefits addBenefit(Benefits benefit) {
        return benefitsRepo.save(benefit);
    }

    @Override
    public Benefits updateBenefit(int benefitId,Benefits benefit) {
        return benefitsRepo.save(benefit);
    }

    @Override
    public void deleteBenefit(int benefitId) {
        benefitsRepo.deleteById(benefitId);
    }

    @Override
    public Benefits getBenefitById(int benefitId) {
        return benefitsRepo.findById(benefitId).orElse(null);
    }

    @Override
    public List<Benefits> getAllBenefits() {
        return benefitsRepo.findAll();
    }

    // Deductions Management
    @Override
    public Deductions addDeduction(Deductions deduction) {
        return deductionsRepo.save(deduction);
    }

    @Override
    public Deductions updateDeduction(int deductionId,Deductions deduction) {
        return deductionsRepo.save(deduction);
    }

    @Override
    public void deleteDeduction(int deductionId) {
        deductionsRepo.deleteById(deductionId);
    }

    @Override
    public Deductions getDeductionById(int deductionId) {
        return deductionsRepo.findById(deductionId).orElse(null);
    }

    @Override
    public List<Deductions> getAllDeductions() {
        return deductionsRepo.findAll();
    }

    // Payment Processing
    public void processPayroll(int empId, LocalDate payrollDate) {

    }



	@Override
	public void processPayment(int empId, LocalDate payrollDate) throws PayrollNotFoundException {
        // Step 1: Calculate payroll
        Payroll payroll = calculatePayroll(empId, payrollDate);

        // Step 2: Verify payroll data
        if (!verifyPayrollData(payroll)) {
            System.out.println("Payroll verification failed. Aborting payroll process.");
            return;
        }

        // Step 3: Save to database
        payrollRepo.save(payroll);
        System.out.println("Payroll processed successfully and saved for Employee ID: " + empId);	
		
		
	}
}
