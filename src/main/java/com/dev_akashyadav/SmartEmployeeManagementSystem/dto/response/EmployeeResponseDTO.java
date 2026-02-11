package com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.AddressRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.AddressEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeResponseDTO {

    private Long id;

    private String empFirstName;

    private String empLastName;

    private Long empId;

    private String empDept;

    private LocalDate empDOJ;

    private String empPersonalMailId;

    private String empWorkEmailId;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    private AddressResponseDTO empAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public LocalDate getEmpDOJ() {
        return empDOJ;
    }

    public void setEmpDOJ(LocalDate empDOJ) {
        this.empDOJ = empDOJ;
    }

    public String getEmpPersonalMailId() {
        return empPersonalMailId;
    }

    public void setEmpPersonalMailId(String empPersonalMailId) {
        this.empPersonalMailId = empPersonalMailId;
    }

    public String getEmpWorkEmailId() {
        return empWorkEmailId;
    }

    public void setEmpWorkEmailId(String empWorkEmailId) {
        this.empWorkEmailId = empWorkEmailId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public AddressResponseDTO getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(AddressResponseDTO empAddress) {
        this.empAddress = empAddress;
    }

    @Override
    public String toString() {
        return "EmployeeResponseDTO{" +
                "id=" + id +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", empId=" + empId +
                ", empDept='" + empDept + '\'' +
                ", empDOJ=" + empDOJ +
                ", empPersonalMailId='" + empPersonalMailId + '\'' +
                ", empWorkEmailId='" + empWorkEmailId + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", empAddress=" + empAddress +
                '}';
    }
}
