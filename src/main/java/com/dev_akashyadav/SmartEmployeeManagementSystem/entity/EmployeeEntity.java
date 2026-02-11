package com.dev_akashyadav.SmartEmployeeManagementSystem.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    @SequenceGenerator(name = "emp_seq", sequenceName = "EMPLOYEE_SEQ", allocationSize = 1)
    private Long id;

    @Column(length = 15)
    private String empFirstName;

    @Column(length = 15)
    private String empLastName;

    @Column(unique = true, nullable = false)
    private Long empId;

    private String empDept;

    private LocalDate empDOJ;

    private String empPersonalMailId;

    @Column(unique = true)
    private String empWorkEmailId;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "addressId",referencedColumnName = "id")
    private AddressEntity empAddressEntity;

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

    public AddressEntity getEmpAddress() {
        return empAddressEntity;
    }

    public void setEmpAddress(AddressEntity empAddressEntity) {
        this.empAddressEntity = empAddressEntity;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
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
                ", empAddressEntity=" + empAddressEntity +
                '}';
    }
}
