package com.co.multimedia.manager.module.siteConfiguration.dataprovider;

import com.co.multimedia.manager.crosscutting.domain.entity.SiteConfigurationEntity;

import java.util.List;
import java.util.UUID;

public interface SiteConfigurationDataProvider {
    public SiteConfigurationEntity findSiteById(UUID id);

    public List<SiteConfigurationEntity> findAllSites();

    public SiteConfigurationEntity save(SiteConfigurationEntity siteEntity);

    public void deleteSiteById(UUID id);
}
