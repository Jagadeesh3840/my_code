package com.employee.service;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveEmployeeDetails() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmail("test@example.com");
        employeeDTO.setFirstName("John");
        employeeDTO.setLastName("Doe");
        employeeDTO.setSalary(50000.0);
        employeeDTO.setMobileNumbers(Arrays.asList("1234567890", "0987654321"));

        Employee employee = new Employee();
        employee.setEmail("test@example.com");
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee result = employeeService.saveEmployeeDetails(employeeDTO);

        assertEquals(employee, result);
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void testGetEmployeeDetails() {
        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setEmail("test@example.com");
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setSalary(50000.0);
        employee.setMobileNumbers("1234567890,0987654321");

        when(employeeRepository.findAll()).thenReturn(Collections.singletonList(employee));

        List<EmployeeDTO> result = employeeService.getEmployeeDetails();

        assertEquals(1, result.size());
        assertEquals("test@example.com", result.get(0).getEmail());
        verify(employeeRepository, times(1)).findAll();
    }
}
