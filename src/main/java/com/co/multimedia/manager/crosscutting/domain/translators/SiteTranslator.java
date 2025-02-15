package com.co.multimedia.manager.crosscutting.domain.translators;

import com.co.multimedia.manager.crosscutting.domain.dto.SiteConfigurationDto;
import com.co.multimedia.manager.crosscutting.domain.entity.SiteConfigurationEntity;

import java.util.ArrayList;
import java.util.List;

public class SiteTranslator {

    public static List<SiteConfigurationDto> toSitesDto(List<SiteConfigurationEntity> siteConfigurationEntities) {
        List<SiteConfigurationDto> sitesDto = new ArrayList<>();
        siteConfigurationEntities.forEach(site -> sitesDto.add(toSiteDto(site)));
        return sitesDto;
    }

    public static SiteConfigurationEntity toSiteEntity(SiteConfigurationDto siteConfigurationDto) {
        return SiteConfigurationEntity.builder()
                .name(siteConfigurationDto.getName())
                .creationDate(siteConfigurationDto.getCreationDate())
                .description(siteConfigurationDto.getDescription())
                .iconPath(siteConfigurationDto.getIconPath())
                .logoPath(siteConfigurationDto.getLogoPath())
                .pageName(siteConfigurationDto.getNameSite())
                .build();
    }

    public static SiteConfigurationDto toSiteDto(SiteConfigurationEntity siteConfigurationEntity) {
        return SiteConfigurationDto.builder()
                .name(siteConfigurationEntity.getName())
                .id(siteConfigurationEntity.getId())
                .creationDate(siteConfigurationEntity.getCreationDate())
                .nameSite(siteConfigurationEntity.getPageName())
                .logoPath(siteConfigurationEntity.getLogoPath())
                .iconPath(siteConfigurationEntity.getIconPath())
                .description(siteConfigurationEntity.getDescription())
                .build();
    }
}
