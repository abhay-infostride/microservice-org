package com.infostride.departmentservice.service;

import com.infostride.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto) throws Exception;

    DepartmentDto getDepartmentByCode(String code);
}
