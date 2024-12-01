package com.hexaware.easyspay.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.Benefits;


@Repository
public interface IBenefitsRepository extends JpaRepository<Benefits,Integer>{


	    // Custom query to find the benefit amount by employee ID
	    @Query("SELECT b.benefitAmount FROM Benefits b WHERE b.benifitId = (SELECT e.benefits.benifitId FROM Employee e WHERE e.empId = :empId)")
	    Double findBenefitAmountByEmployeeId( int empId);
	

	
}
