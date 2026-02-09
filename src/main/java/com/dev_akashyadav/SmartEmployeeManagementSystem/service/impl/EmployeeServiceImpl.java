package com.dev_akashyadav.SmartEmployeeManagementSystem.service.impl;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.EmployeeRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.AddressResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.EmployeeResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.ErrorResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.SuccessResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.AddressEntity;
import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.EmployeeEntity;
import com.dev_akashyadav.SmartEmployeeManagementSystem.exception.ResourceNotFound;
import com.dev_akashyadav.SmartEmployeeManagementSystem.mapper.AddressMapper;
import com.dev_akashyadav.SmartEmployeeManagementSystem.mapper.EmployeeMapper;
import com.dev_akashyadav.SmartEmployeeManagementSystem.repository.EmployeeRepository;
import com.dev_akashyadav.SmartEmployeeManagementSystem.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<EmployeeResponseDTO> getAllEmployees() {
       List<EmployeeEntity> allEmployees= employeeRepository.findAll();
       List<EmployeeResponseDTO> allEmployeeDTO = new ArrayList<>();
       for(EmployeeEntity employee:allEmployees){
           //AddressEntity address = employee.getEmpAddress();
           EmployeeResponseDTO employeeResponseDTO = employeeMapper.toDTO(employee);
           //AddressResponseDTO addressDTO = addressMapper.toDto(address);
          // employeeResponseDTO.setEmpAddress(address);
           allEmployeeDTO.add(employeeResponseDTO);
       }
       return allEmployeeDTO;
    }

    @Override
    public Object getEmployeeById(long id) {
        try{
            EmployeeResponseDTO employee = employeeMapper.toDTO(employeeRepository.getReferenceById(id));
        }catch(EntityNotFoundException en){
            return new ErrorResponseDTO("Employee Not Found",HttpStatus.NOT_FOUND.value(),en.getClass().getSimpleName());
        }
        return employeeMapper.toDTO(employeeRepository.getReferenceById(id));
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
