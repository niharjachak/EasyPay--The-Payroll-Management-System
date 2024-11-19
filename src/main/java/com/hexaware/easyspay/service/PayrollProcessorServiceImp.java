package com.hexaware.easyspay.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.entities.Attendance;
import com.hexaware.easyspay.entities.Benefits;
import com.hexaware.easyspay.entities.Deductions;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.entities.PayrollPolicy;
import com.hexaware.easyspay.repository.BenefitsRepository;
import com.hexaware.easyspay.repository.DeductionsRepository;
import com.hexaware.easyspay.repository.EmployeeRepository;
import com.hexaware.easyspay.repository.PayrollRepository;

@Service
public class PayrollProcessorServiceImp implements IPayrollProcessorService {

    @Autowired
    private PayrollRepository payrollRepo;

    @Autowired
    private BenefitsRepository benefitsRepo;

    @Autowired
    private DeductionsRepository deductionsRepo;
    
    @Autowired
    private EmployeeRepository employeeRepo;

    // Payroll Calculation
    @Override
    public Payroll calculatePayroll(int empId, LocalDate payrollDate) {
        Payroll payroll = new Payroll();
        Employee employee = employeeRepo.findById(empId) .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));
        payroll.setEmployee(employee); 
        payroll.setPayrollDate(payrollDate);

        // Retrieve related data (Employee, Leaves, Attendance, PayrollPolicy, Benefits, Deductions)
        PayrollPolicy policy = payrollRepo.findByEmpId(empId);
        List<Leaves> leaves = leavesRepository.findByEmpIdAndMonth(empId, payrollDate.getMonthValue());
        List<Attendance> attendance = attendanceRepository.findByEmpIdAndMonth(empId, payrollDate.getMonthValue());
        List<Deductions> deductions = deductionsRepo.findAll();
        List<Benefits> benefits = benefitsRepo.findAll();

        // Calculate total leaves
        int totalDaysInMonth = payrollDate.lengthOfMonth();
        int leaveDays = leaves.stream()
            .mapToInt(leave -> (int) ChronoUnit.DAYS.between(leave.getStartDate().toLocalDate(), leave.getEndDate().toLocalDate()) + 1)
            .sum();
        int workingDays = totalDaysInMonth - leaveDays;

        // Calculate overtime hours
        double totalOvertimeHours = attendance.stream()
            .filter(att -> att.getWorkHours() > 8) 
            .mapToDouble(att -> att.getWorkHours() - 8)
            .sum();

        // Calculate gross pay
        double baseSalary = policy.getBaseSalary();
        double overtimePay = totalOvertimeHours * policy.getOvertimeRate();
        payroll.setGrossPay(baseSalary + overtimePay);

        // Calculate benefits and deductions
        double totalBenefits = benefits.stream().mapToDouble(Benefits::getBenefitAmount).sum();
        double totalDeductions = deductions.stream().mapToDouble(Deductions::getDeductionAmount).sum();
        payroll.setBenefits(totalBenefits);
        payroll.setDeductions(totalDeductions);

        return payroll;
    }


    @Override
    public boolean verifyPayrollData(Payroll payroll) {
        // Implement payroll verification logic here
        return false;
    }

    // Benefits Management
    @Override
    public Benefits addBenefit(Benefits benefit) {
        return benefitsRepo.save(benefit);
    }

    @Override
    public Benefits updateBenefit(Benefits benefit) {
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
    public Deductions updateDeduction(Deductions deduction) {
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
    @Override
    public void processPayment(Payroll payroll) {
        // Implement payment processing logic here
    }
}
