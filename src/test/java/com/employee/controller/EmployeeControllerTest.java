package com.employee.controller;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.utils.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveEmployeeDetails() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmail("test@example.com");
        Employee employee = new Employee();
        when(employeeService.saveEmployeeDetails(any(EmployeeDTO.class))).thenReturn(employee);

        ResponseEntity responseEntity = employeeController.saveEmployeeDetails(employeeDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
        verify(employeeService, times(1)).saveEmployeeDetails(any(EmployeeDTO.class));
    }

    @Test
    void testGetEmployeeDetails() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        List<EmployeeDTO> employeeList = Collections.singletonList(employeeDTO);
        when(employeeService.getEmployeeDetails()).thenReturn(employeeList);

        ResponseEntity responseEntity = employeeController.getEmployeeDetails();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employeeList, responseEntity.getBody());
        verify(employeeService, times(1)).getEmployeeDetails();
    }
}