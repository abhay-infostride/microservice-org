package com.infostride.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import com.infostride.departmentservice.dto.DepartmentDto;
import com.infostride.departmentservice.entity.Department;
import com.infostride.departmentservice.mapper.DepartmentMapper;
import com.infostride.departmentservice.repository.DepartmentRepository;
import com.infostride.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) throws Exception {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        var departmentInDb = departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode());
        if (departmentInDb!=null){
            throw new Exception("Department Already Exists with code : "+departmentDto.getDepartmentCode());
        }

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}
