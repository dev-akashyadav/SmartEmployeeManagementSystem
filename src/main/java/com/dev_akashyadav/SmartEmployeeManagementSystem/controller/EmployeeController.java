package com.dev_akashyadav.SmartEmployeeManagementSystem.controller;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.request.EmployeeRequestDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.EmployeeResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.SuccessResponseDTO;
import com.dev_akashyadav.SmartEmployeeManagementSystem.entity.EmployeeEntity;
import com.dev_akashyadav.SmartEmployeeManagementSystem.exception.GlobalExceptionHandler;
import com.dev_akashyadav.SmartEmployeeManagementSystem.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Page<EmployeeResponseDTO> getAllEmployees(
            //http://localhost:8090/api/v1/employees?page=0&size=5&sort=id,asc use for pagination
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return employeeService.findAllWithAddress(pageable);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<SuccessResponseDTO> addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        SuccessResponseDTO response = employeeService.addEmployee(employeeRequestDTO);
        URI location = URI.create("api/v1/employees" + response.id());
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable long id,
                                                             @RequestBody EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.ok().body(employeeService.updateEmployee(id,employeeRequestDTO));
    }

    @PatchMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponseDTO> patchEmployee(@PathVariable long id,
                                                              @RequestBody Map<String,Object> updates){
        return ResponseEntity.ok().body(employeeService.partialUpdate(id,updates));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<SuccessResponseDTO> deleteEmployeeById(@PathVariable long id){
        return ResponseEntity.ok().body(employeeService.deleteEmployeeById(id));
    }
}
