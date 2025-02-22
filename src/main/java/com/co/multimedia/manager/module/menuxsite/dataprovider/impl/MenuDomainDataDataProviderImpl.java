package com.co.multimedia.manager.module.menuxsite.dataprovider.impl;

import com.co.multimedia.manager.crosscutting.domain.entity.MenuSiteEntity;
import com.co.multimedia.manager.crosscutting.domain.repository.MenuDomainRepository;
import com.co.multimedia.manager.module.menuxsite.dataprovider.MenuDomainDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MenuDomainDataDataProviderImpl implements MenuDomainDataProvider {

    @Autowired
    private MenuDomainRepository menuDomainRepository;

    @Override
    public MenuSiteEntity save(MenuSiteEntity menuSite) {
        return this.menuDomainRepository.save(menuSite);
    }

    @Override
    public MenuSiteEntity findById(UUID id) {
        return this.menuDomainRepository.findById(id).orElse(null);
    }

    @Override
    public List<MenuSiteEntity> finAll() {
        return this.menuDomainRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        this.menuDomainRepository.deleteById(id);
    }

    @Override
    public List<MenuSiteEntity> findByDomainId(UUID id) {
        return this.menuDomainRepository.findByDomainId(id);
    }
}
