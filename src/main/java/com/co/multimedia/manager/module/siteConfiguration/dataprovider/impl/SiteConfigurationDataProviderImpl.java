package com.co.multimedia.manager.module.siteConfiguration.dataprovider.impl;

import com.co.multimedia.manager.crosscutting.domain.entity.SiteConfigurationEntity;
import com.co.multimedia.manager.crosscutting.domain.repository.SiteRepository;
import com.co.multimedia.manager.module.siteConfiguration.dataprovider.SiteConfigurationDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SiteConfigurationDataProviderImpl implements SiteConfigurationDataProvider {
    @Autowired
    private SiteRepository siteRepository;

    @Override
    public SiteConfigurationEntity findSiteById(UUID id) {
        return this.siteRepository.findById(id).orElse(null);
    }

    @Override
    public List<SiteConfigurationEntity> findAllSites() {
        return this.siteRepository.findAll();
    }

    @Override
    public SiteConfigurationEntity save(SiteConfigurationEntity siteEntity) {
        return this.siteRepository.save(siteEntity);
    }

    @Override
    public void deleteSiteById(UUID id) {
        this.siteRepository.deleteById(id);
    }
}
