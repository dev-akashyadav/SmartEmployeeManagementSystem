package com.dev_akashyadav.SmartEmployeeManagementSystem.mapper;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.AddressRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.EmployeeRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.EmployeeResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.AddressEntity;
import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.EmployeeEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Component
public class EmployeeMapper {

    AddressMapper addressMapper;

    @Autowired
    public EmployeeMapper(AddressMapper addressMapper){
        this.addressMapper=addressMapper;
    }

    public EmployeeEntity toEntity(EmployeeRequestDTO employeeRequestDTO){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        //employeeEntity.setId(employeeRequestDTO.getId());
        employeeEntity.setEmpFirstName(employeeRequestDTO.getEmpFirstName());
        employeeEntity.setEmpLastName(employeeRequestDTO.getEmpLastName());
        employeeEntity.setEmpId(employeeRequestDTO.getEmpId());
        employeeEntity.setEmpDept(employeeRequestDTO.getEmpDept());
        employeeEntity.setEmpDOJ(employeeRequestDTO.getEmpDOJ());
        employeeEntity.setEmpPersonalMailId(employeeRequestDTO.getEmpPersonalMailId());
        employeeEntity.setEmpWorkEmailId(employeeRequestDTO.getEmpWorkEmailId());
        employeeEntity.setCreatedAt(employeeRequestDTO.getCreatedAt());
        employeeEntity.setModifiedAt(employeeRequestDTO.getModifiedAt());

        AddressRequestDTO addressRequestDTO = employeeRequestDTO.getEmpAddress();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setArea(addressRequestDTO.getArea());
        addressEntity.setCity(addressRequestDTO.getCity());
        addressEntity.setState(addressRequestDTO.getState());
        addressEntity.setPinCode(addressRequestDTO.getPinCode());
        addressEntity.setType(addressRequestDTO.getType());

        employeeEntity.setEmpAddress(addressEntity);
        return employeeEntity;
    }

    public EmployeeResponseDTO toDTO(EmployeeEntity employeeEntity){
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(employeeEntity.getId());
        employeeResponseDTO.setEmpFirstName(employeeEntity.getEmpFirstName());
        employeeResponseDTO.setEmpLastName(employeeEntity.getEmpLastName());
        employeeResponseDTO.setEmpId(employeeEntity.getEmpId());
        employeeResponseDTO.setEmpDept(employeeEntity.getEmpDept());
        employeeResponseDTO.setEmpDOJ(employeeEntity.getEmpDOJ());
        employeeResponseDTO.setEmpPersonalMailId(employeeEntity.getEmpPersonalMailId());
        employeeResponseDTO.setEmpWorkEmailId(employeeEntity.getEmpWorkEmailId());
        employeeResponseDTO.setCreatedAt(employeeEntity.getCreatedAt());
        employeeResponseDTO.setModifiedAt(employeeEntity.getModifiedAt());
        employeeResponseDTO.setEmpAddress(addressMapper.toDto(employeeEntity.getEmpAddress()));
        return employeeResponseDTO;
    }

    public void updateEntityFromDTO(EmployeeEntity employeeEntity,EmployeeRequestDTO employeeRequestDTO){
        employeeEntity.setEmpFirstName(employeeRequestDTO.getEmpFirstName());
        employeeEntity.setEmpLastName(employeeRequestDTO.getEmpLastName());
        employeeEntity.setEmpId(employeeRequestDTO.getEmpId());
        employeeEntity.setEmpDept(employeeRequestDTO.getEmpDept());
        employeeEntity.setEmpDOJ(employeeRequestDTO.getEmpDOJ());
        employeeEntity.setEmpPersonalMailId(employeeRequestDTO.getEmpPersonalMailId());
        employeeEntity.setEmpWorkEmailId(employeeRequestDTO.getEmpWorkEmailId());
        employeeEntity.setCreatedAt(employeeEntity.getCreatedAt());
        //employeeEntity.setModifiedAt(employeeRequestDTO.getModifiedAt());

        AddressRequestDTO addressRequestDTO = employeeRequestDTO.getEmpAddress();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(employeeEntity.getEmpAddress().getId());
        addressEntity.setArea(addressRequestDTO.getArea());
        addressEntity.setCity(addressRequestDTO.getCity());
        addressEntity.setState(addressRequestDTO.getState());
        addressEntity.setPinCode(addressRequestDTO.getPinCode());
        addressEntity.setType(addressRequestDTO.getType());

        employeeEntity.setEmpAddress(addressEntity);
    }

    public <T> T patchEntity(T entity, Map<String, Object> updates, Class<T> clazz) {

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(clazz,key);
            if (field != null) {
                field.setAccessible(true);
                ObjectMapper mapper = new ObjectMapper();
                Object converted = mapper.convertValue(value, field.getType());
                ReflectionUtils.setField(field, entity, converted);
            }
        });

        return entity;
    }
}
