package com.dev_akashyadav.SmartEmployeeManagementSystem.repository;

import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    @Query(
            value = "SELECT e FROM EmployeeEntity e LEFT JOIN FETCH e.empAddressEntity",
            countQuery = "SELECT COUNT(e) FROM EmployeeEntity e"
    )
    Page<EmployeeEntity> findAllWithAddress(Pageable pageable);
}
