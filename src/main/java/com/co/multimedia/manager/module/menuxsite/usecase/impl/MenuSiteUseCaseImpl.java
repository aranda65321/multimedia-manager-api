package com.co.multimedia.manager.module.menuxsite.usecase.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuSiteDto;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;
import com.co.multimedia.manager.crosscutting.domain.entity.SiteConfigurationEntity;
import com.co.multimedia.manager.crosscutting.domain.translators.MenuSiteTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.menu.dataprovider.MenuDataProvider;
import com.co.multimedia.manager.module.menuxsite.dataprovider.MenuSiteDataProvider;
import com.co.multimedia.manager.module.menuxsite.usecase.MenuSiteUseCase;
import com.co.multimedia.manager.module.siteConfiguration.dataprovider.SiteConfigurationDataProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Log4j2
public class MenuSiteUseCaseImpl implements MenuSiteUseCase {
    @Autowired
    private MenuSiteDataProvider menuSiteDataProvider;
    @Autowired
    private SiteConfigurationDataProvider siteConfigurationDataProvider;
    @Autowired
    private MenuDataProvider menuDataProvider;

    @Override
    public MenuSiteDto save(UUID idMenu, UUID idSite) throws ApiProcessException {
        log.info("Realizando persistencia de Menusite ");
        MenuEntity menu = this.menuDataProvider.findMenuById(idMenu);
        SiteConfigurationEntity site = this.siteConfigurationDataProvider.findSiteById(idSite);
        return MenuSiteTranslator.toMenuSiteDto(this.menuSiteDataProvider
                .save(MenuSiteTranslator.toMenuSiteEntity(menu, site)));
    }

    @Override
    public MenuSiteDto findById(UUID id) {
        log.info("Realizando busqueda de Menusite con id {}", id);
        return MenuSiteTranslator.toMenuSiteDto(this.menuSiteDataProvider.findById(id));
    }

    @Override
    public List<MenuSiteDto> finAll() {
        log.info("Realizando busqueda de todos los Menusite ");
        return MenuSiteTranslator.toListMenuSiteDto(this.menuSiteDataProvider.finAll());
    }

    @Override
    public void deleteById(UUID id) {
        log.info("Realizando borrado de Menusite con id {}", id);
        this.menuSiteDataProvider.deleteById(id);
    }
}
