package com.hexaware.easyspay.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import com.hexaware.easyspay.entities.Benefits;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Deductions;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PayrollProcessorServiceImpTest {

    @InjectMocks
    private PayrollProcessorServiceImp payrollProcessorService;

    @Mock
    private Employee employee;

    @Mock
    private Benefits benefit;

    @Mock
    private Deductions deduction;

 

    @Test
    void testCalculatePayroll() {

    }

    @Test
    void testVerifyPayrollData() {

    }

    @Test
    void testAddBenefit() {
        Benefits benefit = new Benefits();
        benefit.setBenifitName("Health Insurance");
        benefit.setBenefitAmount(500.00);

        when(payrollProcessorService.addBenefit(any(Benefits.class))).thenReturn(benefit);

        Benefits addedBenefit = payrollProcessorService.addBenefit(benefit);

        assertNotNull(addedBenefit);
        assertEquals("Health Insurance", addedBenefit.getBenifitName());
    }

    @Test
    void testUpdateBenefit() {
        when(payrollProcessorService.getBenefitById(1)).thenReturn(benefit);
        when(payrollProcessorService.updateBenefit(any(Benefits.class))).thenReturn(benefit);

        Benefits updatedBenefit = payrollProcessorService.updateBenefit(benefit);

        assertNotNull(updatedBenefit);
    }

    @Test
    void testDeleteBenefit() {
        doNothing().when(payrollProcessorService).deleteBenefit(1);

        payrollProcessorService.deleteBenefit(1);

        verify(payrollProcessorService, times(1)).deleteBenefit(1);
    }

    @Test
    void testGetBenefitById() {
        when(payrollProcessorService.getBenefitById(1)).thenReturn(benefit);

        Benefits retrievedBenefit = payrollProcessorService.getBenefitById(1);

        assertNotNull(retrievedBenefit);
    }

    @Test
    void testGetAllBenefits() {
        when(payrollProcessorService.getAllBenefits()).thenReturn(Arrays.asList(benefit));

        List<Benefits> benefits = payrollProcessorService.getAllBenefits();

        assertFalse(benefits.isEmpty());
    }

    @Test
    void testAddDeduction() {
        Deductions deduction = new Deductions();
        deduction.setDeductionName("Tax");
        deduction.setDeductionAmount(200.00);

        when(payrollProcessorService.addDeduction(any(Deductions.class))).thenReturn(deduction);

        Deductions addedDeduction = payrollProcessorService.addDeduction(deduction);

        assertNotNull(addedDeduction);
        assertEquals("Tax", addedDeduction.getDeductionName());
    }

    @Test
    void testUpdateDeduction() {
        when(payrollProcessorService.getDeductionById(1)).thenReturn(deduction);
        when(payrollProcessorService.updateDeduction(any(Deductions.class))).thenReturn(deduction);

        Deductions updatedDeduction = payrollProcessorService.updateDeduction(deduction);

        assertNotNull(updatedDeduction);
    }

    @Test
    void testDeleteDeduction() {
        doNothing().when(payrollProcessorService).deleteDeduction(1);

        payrollProcessorService.deleteDeduction(1);

        verify(payrollProcessorService, times(1)).deleteDeduction(1);
    }

    @Test
    void testGetDeductionById() {
        when(payrollProcessorService.getDeductionById(1)).thenReturn(deduction);

        Deductions retrievedDeduction = payrollProcessorService.getDeductionById(1);

        assertNotNull(retrievedDeduction);
    }

    @Test
    void testGetAllDeductions() {
        when(payrollProcessorService.getAllDeductions()).thenReturn(Arrays.asList(deduction));

        List<Deductions> deductions = payrollProcessorService.getAllDeductions();

        assertFalse(deductions.isEmpty());
    }


}
