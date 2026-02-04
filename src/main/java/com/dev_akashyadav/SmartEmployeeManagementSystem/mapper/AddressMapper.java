package com.dev_akashyadav.SmartEmployeeManagementSystem.mapper;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.AddressRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.AddressResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressEntity toEntity(AddressRequestDTO addressRequestDTO){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressRequestDTO.getId());
        addressEntity.setPinCode(addressRequestDTO.getPinCode());
        addressEntity.setState(addressRequestDTO.getState());
        addressEntity.setCity(addressRequestDTO.getCity());
        addressEntity.setArea(addressRequestDTO.getArea());
        addressEntity.setType(addressRequestDTO.getType());
        return addressEntity;
    }

    public AddressResponseDTO toDto(AddressEntity addressEntity){
        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
        addressResponseDTO.setId(addressEntity.getId());
        addressResponseDTO.setPinCode(addressEntity.getPinCode());
        addressResponseDTO.setState(addressEntity.getState());
        addressResponseDTO.setCity(addressEntity.getCity());
        addressResponseDTO.setArea(addressEntity.getArea());
        addressResponseDTO.setType(addressEntity.getType());
        return addressResponseDTO;
    }
}
