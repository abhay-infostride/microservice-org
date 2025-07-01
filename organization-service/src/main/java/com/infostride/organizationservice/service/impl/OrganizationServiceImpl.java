package com.infostride.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import com.infostride.organizationservice.dto.OrganizationDto;
import com.infostride.organizationservice.entity.Organization;
import com.infostride.organizationservice.mapper.OrganizationMapper;
import com.infostride.organizationservice.repository.OrganizationRepository;
import com.infostride.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
