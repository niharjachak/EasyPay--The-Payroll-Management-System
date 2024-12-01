package com.hexaware.easyspay.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "deductions")
public class Deductions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deductionId;

    @NotBlank(message = "Deduction name must not be blank.")
    @Size(min = 3, max = 50, message = "Deduction name must be between 3 and 50 characters.")
    @Pattern(regexp = "[A-Za-z ]+", message = "Deduction name must only contain letters and spaces.")
    private String deductionName;

    @NotNull(message = "Deduction amount must not be null.")
    @DecimalMin(value = "0.01", message = "Deduction amount must be greater than 0.")
    private double deductionAmount;

 

    public Deductions() {}

    public Deductions(int deductionId, String deductionName, double deductionAmount, Employee employee) {
        this.deductionId = deductionId;
        this.deductionName = deductionName;
        this.deductionAmount = deductionAmount;
    }

    // Getters and Setters
    public int getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(int deductionId) {
        this.deductionId = deductionId;
    }

    public String getDeductionName() {
        return deductionName;
    }

    public void setDeductionName(String deductionName) {
        this.deductionName = deductionName;
    }

    public double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }


  

    @Override
    public String toString() {
        return "Deductions [deductionId=" + deductionId + ", deductionName=" + deductionName + 
               ", deductionAmount=" + deductionAmount + ", employee=" +  "]";
    }
}
