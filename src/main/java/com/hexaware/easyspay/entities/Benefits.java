package com.hexaware.easyspay.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Benefits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int benifitId;

    @NotBlank(message = "Benefit name must not be blank.")
    @Size(min = 3, max = 50, message = "Benefit name must be between 3 and 50 characters.")
    @Pattern(regexp = "[A-Za-z ]+", message = "Benefit name must only contain letters and spaces.")
    private String benifitName;

    @Positive(message = "Benefit amount must be positive.")
    @DecimalMin(value = "0.1", inclusive = true, message = "Benefit amount must be greater than or equal to 0.1.")
    private double benefitAmount;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    @NotNull(message = "Employee reference must not be null.")
    private Employee employee;

    public Benefits() {
        super();
    }

    

    public Benefits(int benifitId,
			@NotBlank(message = "Benefit name must not be blank.") @Size(min = 3, max = 50, message = "Benefit name must be between 3 and 50 characters.") @Pattern(regexp = "[A-Za-z ]+", message = "Benefit name must only contain letters and spaces.") String benifitName,
			@Positive(message = "Benefit amount must be positive.") @DecimalMin(value = "0.1", inclusive = true, message = "Benefit amount must be greater than or equal to 0.1.") double benefitAmount,
			@NotNull(message = "Employee reference must not be null.") Employee employee) {
		super();
		this.benifitId = benifitId;
		this.benifitName = benifitName;
		this.benefitAmount = benefitAmount;
		this.employee = employee;
	}



	public int getBenifitId() {
        return benifitId;
    }

    public void setBenifitId(int benifitId) {
        this.benifitId = benifitId;
    }

    public String getBenifitName() {
        return benifitName;
    }

    public void setBenifitName(String benifitName) {
        this.benifitName = benifitName;
    }

    public double getBenefitAmount() {
        return benefitAmount;
    }

    public void setBenefitAmount(double benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Benefits [benifitId=" + benifitId + ", benifitName=" + benifitName + 
               ", benefitAmount=" + benefitAmount + ", employee=" + employee + "]";
    }
}

