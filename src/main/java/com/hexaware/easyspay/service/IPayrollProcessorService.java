package com.hexaware.easyspay.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.easyspay.entities.Benefits;
import com.hexaware.easyspay.entities.Deductions;
import com.hexaware.easyspay.entities.Payroll;

public interface IPayrollProcessorService {

    // Payroll Calculation
    Payroll calculatePayroll(int empId, LocalDate payrollDate);

    // Payroll Data Verification
    boolean verifyPayrollData(Payroll payroll);

    // Benefits Management
    Benefits addBenefit(Benefits benefit);
    Benefits updateBenefit(Benefits benefit);
    void deleteBenefit(int benefitId);
    Benefits getBenefitById(int benefitId);
    List<Benefits> getAllBenefits();

    // Deductions Management
    Deductions addDeduction(Deductions deduction);
    Deductions updateDeduction(Deductions deduction);
    void deleteDeduction(int deductionId);
    Deductions getDeductionById(int deductionId);
    List<Deductions> getAllDeductions();

    // Payment Processing
    void processPayment(Payroll payroll);
}
