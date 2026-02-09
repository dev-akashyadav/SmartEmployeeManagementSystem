package com.dev_akashyadav.SmartEmployeeManagementSystem.controller;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.EmployeeRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.EmployeeResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.SuccessResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.exception.GlobalExceptionHandler;
import com.dev_akashyadav.SmartEmployeeManagementSystem.exception.ResourceNotFound;
import com.dev_akashyadav.SmartEmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    EmployeeService employeeService;

    GlobalExceptionHandler globalExceptionHandler;

    @Autowired
    public EmployeeController(EmployeeService employeeService, GlobalExceptionHandler globalExceptionHandler){
        this.employeeService = employeeService;
        this.globalExceptionHandler = globalExceptionHandler;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees(){
        List<EmployeeResponseDTO> allEmployeesDTO = employeeService.getAllEmployees();
        return ResponseEntity.ok().body(allEmployeesDTO);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PostMapping("/addemployee")
    public ResponseEntity<SuccessResponseDTO> addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.created(URI.create("employees/addEmployee" + employeeRequestDTO.getEmpId().toString()))
            .body(employeeService.addEmployee(employeeRequestDTO));
    }

    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity<SuccessResponseDTO> deleteEmployeeById(@PathVariable long id){
        return ResponseEntity.ok().body(employeeService.deleteEmployeeById(id));
    }
}
