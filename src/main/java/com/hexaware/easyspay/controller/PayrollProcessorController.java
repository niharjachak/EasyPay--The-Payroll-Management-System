package com.hexaware.easyspay.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.easyspay.entities.Benefits;
import com.hexaware.easyspay.entities.Deductions;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.service.IPayrollProcessorService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/payroll")
public class PayrollProcessorController {

    @Autowired
    private IPayrollProcessorService service;

    // Payroll Calculation
    @PostMapping("/calculate/{empId}")
    public Payroll calculatePayroll(@PathVariable int empId, @Valid @RequestBody LocalDate payrollDate) {
        return service.calculatePayroll(empId, payrollDate);
    }

    // Payroll Verification
    @PostMapping("/verify")
    public boolean verifyPayrollData(@Valid @RequestBody Payroll payroll) {
        return service.verifyPayrollData(payroll);
    }

    // Benefits Management
    @PostMapping("/benefits/add")
    public Benefits addBenefit(@Valid @RequestBody Benefits benefit) {
        return service.addBenefit(benefit);
    }

    @PutMapping("/benefits/update")
    public Benefits updateBenefit(@Valid @RequestBody Benefits benefit) {
        return service.updateBenefit(benefit);
    }

    @DeleteMapping("/benefits/delete/{benefitId}")
    public String deleteBenefit(@PathVariable int benefitId) {
        service.deleteBenefit(benefitId);
        return "Benefit record deleted for BenefitId " + benefitId;
    }

    @GetMapping("/benefits/{benefitId}")
    public Benefits getBenefitById(@PathVariable int benefitId) {
        return service.getBenefitById(benefitId);
    }

    @GetMapping("/benefits/all")
    public List<Benefits> getAllBenefits() {
        return service.getAllBenefits();
    }

    // Deductions Management
    @PostMapping("/deductions/add")
    public Deductions addDeduction(@Valid @RequestBody Deductions deduction) {
        return service.addDeduction(deduction);
    }

    @PutMapping("/deductions/update")
    public Deductions updateDeduction(@Valid @RequestBody Deductions deduction) {
        return service.updateDeduction(deduction);
    }

    @DeleteMapping("/deductions/delete/{deductionId}")
    public String deleteDeduction(@PathVariable int deductionId) {
        service.deleteDeduction(deductionId);
        return "Deduction record deleted for DeductionId " + deductionId;
    }

    @GetMapping("/deductions/{deductionId}")
    public Deductions getDeductionById(@PathVariable int deductionId) {
        return service.getDeductionById(deductionId);
    }

    @GetMapping("/deductions/all")
    public List<Deductions> getAllDeductions() {
        return service.getAllDeductions();
    }

    // Payment Processing
    @PostMapping("/payment/process")
    public String processPayment(@Valid @RequestBody Payroll payroll) {
        service.processPayment(payroll);
        return "Payment processed successfully for PayrollId " + payroll.getPayrollId();
    }
}
