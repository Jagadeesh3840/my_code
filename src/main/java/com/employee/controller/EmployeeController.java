package com.employee.controller;

import com.employee.constants.APIConstants;
import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.utils.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(APIConstants.EmployeeConstants.BASE_END_POINT)
@AllArgsConstructor
public class EmployeeController {

    EmployeeService service;

    @PostMapping
    public ResponseEntity saveEmployeeDetails(@RequestBody @Validated EmployeeDTO employeeDto) {
        CommonUtils.isValidEmail(employeeDto.getEmail());
        Employee employeeDetails = service.saveEmployeeDetails(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDetails);
    }

    @GetMapping
    public ResponseEntity getEmployeeDetails() {
        List<EmployeeDTO> employeeList = service.getEmployeeDetails();
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }
}
