package com.co.multimedia.manager.crosscutting.domain.translators;

import com.co.multimedia.manager.crosscutting.domain.dto.DomainDto;
import com.co.multimedia.manager.crosscutting.domain.entity.DomainEntity;

import java.util.ArrayList;
import java.util.List;

public class DomainTranslator {

    public static List<DomainDto> toDomainsDto(List<DomainEntity> siteConfigurationEntities) {
        List<DomainDto> sitesDto = new ArrayList<>();
        siteConfigurationEntities.forEach(site -> sitesDto.add(toDomainDto(site)));
        return sitesDto;
    }

    public static DomainEntity toDomainEntity(DomainDto domainDto) {
        return DomainEntity.builder()
                .name(domainDto.getName())
                .creationDate(domainDto.getCreationDate())
                .description(domainDto.getDescription())
                .iconPath(domainDto.getIconPath())
                .logoPath(domainDto.getLogoPath())
                .pageName(domainDto.getNameSite())
                .build();
    }

    public static DomainDto toDomainDto(DomainEntity domainEntity) {
        return DomainDto.builder()
                .name(domainEntity.getName())
                .id(domainEntity.getId())
                .creationDate(domainEntity.getCreationDate())
                .nameSite(domainEntity.getPageName())
                .logoPath(domainEntity.getLogoPath())
                .iconPath(domainEntity.getIconPath())
                .description(domainEntity.getDescription())
                .build();
    }
}
