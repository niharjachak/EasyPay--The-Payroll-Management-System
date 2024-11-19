package com.hexaware.easyspay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.Benefits;


@Repository
public interface BenefitsRepository extends JpaRepository<Benefits,Integer>{

}
