package com.hexaware.easyspay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.entities.Attendance;

@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance ,Integer> {

	
}
