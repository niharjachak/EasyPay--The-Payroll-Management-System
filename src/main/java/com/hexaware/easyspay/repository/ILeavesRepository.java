package com.hexaware.easyspay.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.Leaves;

@Repository
public interface ILeavesRepository extends JpaRepository<Leaves ,Integer> {
	


}
