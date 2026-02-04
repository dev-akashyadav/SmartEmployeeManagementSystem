package com.dev_akashyadav.SmartEmployeeManagementSystem.repository;

import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
