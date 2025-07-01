package com.infostride.employeeservice.service;

import com.infostride.employeeservice.dto.APIResponseDto;
import com.infostride.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
