package com.dev_akashyadav.SmartEmployeeManagementSystem.service;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.EmployeeRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.EmployeeResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.SuccessResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface EmployeeService {
    Page<EmployeeResponseDTO> findAllWithAddress(Pageable pageable);

    SuccessResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO getEmployeeById(long id);

    SuccessResponseDTO deleteEmployeeById(long id);

    EmployeeResponseDTO updateEmployee(long id, EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO partialUpdate(Long id, Map<String, Object> updates);
}
