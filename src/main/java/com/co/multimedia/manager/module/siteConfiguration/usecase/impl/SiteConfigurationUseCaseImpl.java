package com.co.multimedia.manager.module.siteConfiguration.usecase.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.SiteConfigurationDto;
import com.co.multimedia.manager.crosscutting.domain.translators.SiteTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.siteConfiguration.dataprovider.SiteConfigurationDataProvider;
import com.co.multimedia.manager.module.siteConfiguration.usecase.SiteConfigurationUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@Log4j2
public class SiteConfigurationUseCaseImpl implements SiteConfigurationUseCase {
    @Autowired
    private SiteConfigurationDataProvider siteConfigurationDataProvider;

    @Override
    public SiteConfigurationDto findSiteById(UUID id) throws ApiProcessException {
        log.info("Realizando busqueda de Site con id {}", id);
        return SiteTranslator.toSiteDto(this.siteConfigurationDataProvider.findSiteById(id));
    }

    @Override
    public List<SiteConfigurationDto> findAllSite() throws ApiProcessException {
        log.info("Realizando busqueda de todos los sites ");
        return SiteTranslator.toSitesDto(this.siteConfigurationDataProvider.findAllSites());
    }

    @Override
    public SiteConfigurationDto save(SiteConfigurationDto siteConfigurationDto) throws ApiProcessException {
        log.info("Realizando persistencia de site con name: {}", siteConfigurationDto.getName());
        siteConfigurationDto.setCreationDate(LocalDateTime.now());
        return SiteTranslator.toSiteDto(this.siteConfigurationDataProvider.save(SiteTranslator
                .toSiteEntity(siteConfigurationDto)));
    }

    @Override
    public void deleteSiteById(UUID id) throws ApiProcessException {
        log.info("Realizando borrado de site con id {}", id);
        this.siteConfigurationDataProvider.deleteSiteById(id);
    }
}
