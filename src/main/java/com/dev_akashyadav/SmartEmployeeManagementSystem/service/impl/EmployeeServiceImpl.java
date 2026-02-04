package com.dev_akashyadav.SmartEmployeeManagementSystem.service.impl;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.EmployeeRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.EmployeeResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.SuccessResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.mapper.EmployeeMapper;
import com.dev_akashyadav.SmartEmployeeManagementSystem.repository.EmployeeRepository;
import com.dev_akashyadav.SmartEmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
         return employeeRepository.findAll().stream().map(employeeMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeResponseDTO> getEmployeeById(long id) {
        return Optional.ofNullable(employeeMapper.toDTO(employeeRepository.getReferenceById(id)));
    }

    @Override
    public SuccessResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO) {
        employeeRepository.save(employeeMapper.toEntity(employeeRequestDTO));
        return new SuccessResponseDTO("Employee Added Successfully",HttpStatus.OK.value());
    }

    @Override
    public SuccessResponseDTO deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
        return new SuccessResponseDTO("Employee Deleted Successfully.", HttpStatus.NO_CONTENT.value());
    }
}
