package com.co.multimedia.manager.module.menuxsite.dataprovider.impl;

import com.co.multimedia.manager.crosscutting.domain.entity.MenuSiteEntity;
import com.co.multimedia.manager.crosscutting.domain.repository.MenuSiteRepository;
import com.co.multimedia.manager.module.menuxsite.dataprovider.MenuSiteDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MenuSiteDataProviderImpl implements MenuSiteDataProvider {

    @Autowired
    private MenuSiteRepository menuSiteRepository;

    @Override
    public MenuSiteEntity save(MenuSiteEntity menuSite) {
        return this.menuSiteRepository.save(menuSite);
    }

    @Override
    public MenuSiteEntity findById(UUID id) {
        return this.menuSiteRepository.findById(id).orElse(null);
    }

    @Override
    public List<MenuSiteEntity> finAll() {
        return this.menuSiteRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        this.menuSiteRepository.deleteById(id);
    }

    @Override
    public List<MenuSiteEntity> findBySiteConfigurationEntityId(UUID id) {
        return this.menuSiteRepository.findBySiteConfigurationId(id);
    }
}
