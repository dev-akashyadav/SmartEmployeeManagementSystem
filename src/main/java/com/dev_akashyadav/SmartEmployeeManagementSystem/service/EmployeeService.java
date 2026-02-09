package com.dev_akashyadav.SmartEmployeeManagementSystem.service;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.EmployeeRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.EmployeeResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.SuccessResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeResponseDTO> getAllEmployees();

    SuccessResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO);

    Object getEmployeeById(long id);

    SuccessResponseDTO deleteEmployeeById(long id);
}
