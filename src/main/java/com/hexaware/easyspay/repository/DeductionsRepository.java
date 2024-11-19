package com.hexaware.easyspay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.Deductions;

@Repository
public interface DeductionsRepository extends JpaRepository<Deductions,Integer>{

}
