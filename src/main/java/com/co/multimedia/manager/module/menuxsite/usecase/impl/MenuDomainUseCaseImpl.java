package com.co.multimedia.manager.module.menuxsite.usecase.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuSiteDto;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;
import com.co.multimedia.manager.crosscutting.domain.entity.DomainEntity;
import com.co.multimedia.manager.crosscutting.domain.translators.MenuSiteTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.menu.dataprovider.MenuDataProvider;
import com.co.multimedia.manager.module.menuxsite.dataprovider.MenuDomainProvider;
import com.co.multimedia.manager.module.menuxsite.usecase.MenuDomainUseCase;
import com.co.multimedia.manager.module.domain.dataprovider.DomainDataProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Log4j2
public class MenuDomainUseCaseImpl implements MenuDomainUseCase {
    @Autowired
    private MenuDomainProvider menuDomainProvider;
    @Autowired
    private DomainDataProvider domainDataProvider;
    @Autowired
    private MenuDataProvider menuDataProvider;

    @Override
    public MenuSiteDto save(UUID idMenu, UUID idSite) throws ApiProcessException {
        log.info("Realizando persistencia de Menusite ");
        MenuEntity menu = this.menuDataProvider.findMenuById(idMenu);
        DomainEntity site = this.domainDataProvider.findById(idSite);
        return MenuSiteTranslator.toMenuSiteDto(this.menuDomainProvider
                .save(MenuSiteTranslator.toMenuSiteEntity(menu, site)));
    }

    @Override
    public MenuSiteDto findById(UUID id) {
        log.info("Realizando busqueda de Menusite con id {}", id);
        return MenuSiteTranslator.toMenuSiteDto(this.menuDomainProvider.findById(id));
    }

    @Override
    public List<MenuSiteDto> finAll() {
        log.info("Realizando busqueda de todos los Menusite ");
        return MenuSiteTranslator.toListMenuSiteDto(this.menuDomainProvider.finAll());
    }

    @Override
    public void deleteById(UUID id) {
        log.info("Realizando borrado de Menusite con id {}", id);
        this.menuDomainProvider.deleteById(id);
    }

    @Override
    public List<MenuSiteDto> findBySiteConfigurationEntityId(UUID id) {
        log.info("Realizando busqueda Menu x Site por siteId {}", id);
        return MenuSiteTranslator.toListMenuSiteDto(this.menuDomainProvider.findBySiteConfigurationEntityId(id));
    }
}
