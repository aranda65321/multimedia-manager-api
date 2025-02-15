package com.co.multimedia.manager.module.siteConfiguration.usecase;

import com.co.multimedia.manager.crosscutting.domain.dto.SiteConfigurationDto;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;

import java.util.List;
import java.util.UUID;

public interface SiteConfigurationUseCase {
    public SiteConfigurationDto findSiteById(UUID id) throws ApiProcessException;

    public List<SiteConfigurationDto> findAllSite() throws ApiProcessException;

    public SiteConfigurationDto save(SiteConfigurationDto siteConfigurationDto) throws ApiProcessException;

    public void deleteSiteById(UUID id) throws ApiProcessException;
}
