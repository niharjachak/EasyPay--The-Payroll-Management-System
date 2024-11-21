package com.hexaware.easyspay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.Deductions;

@Repository
public interface IDeductionsRepository extends JpaRepository<Deductions,Integer>{

    // Custom query to find deductions by employee ID
    @Query("SELECT d FROM Deductions d WHERE d.employee.empId = :empId")
    List<Deductions> findByEmployeeId(@Param("empId") int empId);
	
}
