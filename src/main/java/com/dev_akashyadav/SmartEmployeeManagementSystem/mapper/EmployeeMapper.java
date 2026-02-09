package com.dev_akashyadav.SmartEmployeeManagementSystem.mapper;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.EmployeeRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.EmployeeResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeEntity toEntity(EmployeeRequestDTO employeeRequestDTO){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeRequestDTO.getId());
        employeeEntity.setEmpFirstName(employeeRequestDTO.getEmpFirstName());
        employeeEntity.setEmpLastName(employeeRequestDTO.getEmpLastName());
        employeeEntity.setEmpId(employeeRequestDTO.getId());
        employeeEntity.setEmpDept(employeeRequestDTO.getEmpDept());
        employeeEntity.setEmpDOJ(employeeRequestDTO.getEmpDOJ());
        employeeEntity.setEmpPersonalMailId(employeeRequestDTO.getEmpPersonalMailId());
        employeeEntity.setEmpWorkEmailId(employeeRequestDTO.getEmpWorkEmailId());
        employeeEntity.setCreatedAt(employeeRequestDTO.getCreatedAt());
        employeeEntity.setModifiedAt(employeeRequestDTO.getModifiedAt());
        employeeEntity.setEmpAddress(employeeRequestDTO.getEmpAddress());
        return employeeEntity;
    }

    public EmployeeResponseDTO toDTO(EmployeeEntity employeeEntity){
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(employeeEntity.getId());
        employeeResponseDTO.setEmpFirstName(employeeEntity.getEmpFirstName());
        employeeResponseDTO.setEmpLastName(employeeEntity.getEmpLastName());
        employeeResponseDTO.setEmpId(employeeEntity.getId());
        employeeResponseDTO.setEmpDept(employeeEntity.getEmpDept());
        employeeResponseDTO.setEmpDOJ(employeeEntity.getEmpDOJ());
        employeeResponseDTO.setEmpPersonalMailId(employeeEntity.getEmpPersonalMailId());
        employeeResponseDTO.setEmpWorkEmailId(employeeEntity.getEmpWorkEmailId());
        employeeResponseDTO.setCreatedAt(employeeEntity.getCreatedAt());
        employeeResponseDTO.setModifiedAt(employeeEntity.getModifiedAt());
        employeeResponseDTO.setEmpAddress(employeeEntity.getEmpAddress());
        return employeeResponseDTO;
    }
}
