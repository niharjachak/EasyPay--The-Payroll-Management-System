package com.hexaware.easyspay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.Payroll;


@Repository
public interface PayrollRepository extends JpaRepository<Payroll,Integer>{

}
