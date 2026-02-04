package com.dev_akashyadav.SmartEmployeeManagementSystem.controller;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.EmployeeRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.EmployeeResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.SuccessResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.exception.ResourceNotFound;
import com.dev_akashyadav.SmartEmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
         this.employeeService = employeeService;
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable long id) throws ResourceNotFound {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFound("Employee with Employee Id: " + id +" is not found in system.")));
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<SuccessResponseDTO> addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.created(URI.create("employees/addEmployee" + employeeRequestDTO.getEmpId().toString()))
                .body(employeeService.addEmployee(employeeRequestDTO));
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<SuccessResponseDTO> deleteEmployeeById(@PathVariable long id){
        return ResponseEntity.ok().body(employeeService.deleteEmployeeById(id));
    }
}
