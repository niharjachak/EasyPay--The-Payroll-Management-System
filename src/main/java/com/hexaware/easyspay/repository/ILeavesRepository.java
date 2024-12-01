package com.hexaware.easyspay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.Leaves;

@Repository
public interface ILeavesRepository extends JpaRepository<Leaves ,Integer> {
	
	@Query("select l from Leaves l where l.manager.empId =:managerId")
	List <Leaves> findByManagerEmpId(int managerId);

}
