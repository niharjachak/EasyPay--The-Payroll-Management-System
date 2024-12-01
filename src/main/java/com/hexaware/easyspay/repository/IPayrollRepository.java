package com.hexaware.easyspay.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.easyspay.entities.Payroll;


public interface  IPayrollRepository extends JpaRepository<Payroll,Integer>{
	// Custom method to find payrolls for a specific employee
    List<Payroll> findByEmployeeEmpId(int empId);

    
    @Query("SELECT p FROM Payroll p WHERE p.employee.manager.empId = :managerId")
    List<Payroll> findByEmployeeManagerEmpId( int managerId);
    
    @Query("SELECT p FROM Payroll p WHERE p.payrollDate BETWEEN :startDate AND :endDate")
    List<Payroll> findPayrollsByDateRange( LocalDate startDate, LocalDate endDate);

}
