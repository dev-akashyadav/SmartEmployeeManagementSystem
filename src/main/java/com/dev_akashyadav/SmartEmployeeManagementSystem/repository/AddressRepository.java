package com.dev_akashyadav.SmartEmployeeManagementSystem.repository;

import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
}
