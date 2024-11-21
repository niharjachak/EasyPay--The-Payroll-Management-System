package com.hexaware.easyspay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.Benefits;


@Repository
public interface IBenefitsRepository extends JpaRepository<Benefits,Integer>{

	 // Custom query to find benefits by employee ID
    @Query("SELECT b FROM Benefits b WHERE b.employee.empId = :empId")
    List<Benefits> findByEmployeeId(@Param("empId") int empId);
	
}
