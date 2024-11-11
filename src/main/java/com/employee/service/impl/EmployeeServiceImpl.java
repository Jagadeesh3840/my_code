package com.employee.service.impl;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.employee.utils.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository repository;

    @Override
    public Employee saveEmployeeDetails(EmployeeDTO employeeDto) {
        Employee employee = new Employee();
        employee.setDoj(employeeDto.getDoj());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setMobileNumbers(String.join(",", employeeDto.getMobileNumbers()));
        return repository.save(employee);
    }

    @Override
    public   List<EmployeeDTO> getEmployeeDetails() {
        List<Employee> list = repository.findAll();
        List<EmployeeDTO> employeeList = new ArrayList<>();
        list.forEach(rec -> {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setEmployeeId(rec.getEmployeeId());
            dto.setDoj(rec.getDoj());
            dto.setFirstName(rec.getFirstName());
            dto.setEmail(rec.getEmail());
            dto.setLastName(rec.getLastName());
            dto.setMobileNumbers(Arrays.asList(rec.getMobileNumbers().split(",")));
            dto.setSalary(rec.getSalary());
            dto.setCessAmount(CommonUtils.calculateCess(rec.getSalary()));
            dto.setTaxAmount(CommonUtils.calculateTax(rec.getSalary()));
            employeeList.add(dto);
        });

        return employeeList;
    }
}
