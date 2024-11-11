package com.employee.service;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployeeDetails(EmployeeDTO employeeDto);

    List<EmployeeDTO> getEmployeeDetails();
}
