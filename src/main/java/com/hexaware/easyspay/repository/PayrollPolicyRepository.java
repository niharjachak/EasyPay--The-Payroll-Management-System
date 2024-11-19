package com.hexaware.easyspay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.PayrollPolicy;


@Repository
public interface PayrollPolicyRepository extends JpaRepository<PayrollPolicy,Integer> {

}
