package com.dev_akashyadav.SmartEmployeeManagementSystem.service.impl;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.EmployeeRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.EmployeeResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.SuccessResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.EmployeeEntity;
import com.dev_akashyadav.SmartEmployeeManagementSystem.exception.ResourceNotFoundException;
import com.dev_akashyadav.SmartEmployeeManagementSystem.mapper.AddressMapper;
import com.dev_akashyadav.SmartEmployeeManagementSystem.mapper.EmployeeMapper;
import com.dev_akashyadav.SmartEmployeeManagementSystem.repository.EmployeeRepository;
import com.dev_akashyadav.SmartEmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    EmployeeMapper employeeMapper;

    AddressMapper addressMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,EmployeeMapper employeeMapper,AddressMapper addressMapper){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public Page<EmployeeResponseDTO> findAllWithAddress(Pageable pageable) {
        return employeeRepository.findAllWithAddress(pageable)
                .map(employeeMapper::toDTO);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(long id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        return employeeMapper.toDTO(employee);
    }

    @Override
    public SuccessResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO) {
        if(employeeRepository.findById(employeeRequestDTO.getEmpId()).isPresent()){
            throw new RuntimeException("Employee ID "+ employeeRequestDTO.getEmpId() +" already exists");
        }
        EmployeeEntity employee = employeeRepository.save(employeeMapper.toEntity(employeeRequestDTO));
        return new SuccessResponseDTO(employee.getId(),"Employee Created Successfully");
    }

    @Override
    public SuccessResponseDTO deleteEmployeeById(long id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.delete(employee);
        return new SuccessResponseDTO(id,"Employee Deleted Successfully.");
    }

    @Override
    public EmployeeResponseDTO updateEmployee(long id, EmployeeRequestDTO employeeRequestDTO) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employeeMapper.updateEntityFromDTO(employee,employeeRequestDTO);
        return employeeMapper.toDTO(employeeRepository.save(employee));
    }

    @Transactional
    public EmployeeResponseDTO partialUpdate(Long id, Map<String, Object> updates) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employeeMapper.patchEntity(employee, updates, EmployeeEntity.class);
        return employeeMapper.toDTO(employeeRepository.save(employee));
    }
}
