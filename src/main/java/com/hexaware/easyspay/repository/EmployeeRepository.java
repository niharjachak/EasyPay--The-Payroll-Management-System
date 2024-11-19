package com.hexaware.easyspay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
