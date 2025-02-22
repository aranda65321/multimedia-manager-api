package com.co.multimedia.manager.module.menuxsite.usecase.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuDto;
import com.co.multimedia.manager.crosscutting.domain.dto.MenuSiteDto;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;
import com.co.multimedia.manager.crosscutting.domain.entity.DomainEntity;
import com.co.multimedia.manager.crosscutting.domain.translators.MenuDomainTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.menu.dataprovider.MenuDataProvider;
import com.co.multimedia.manager.module.menuxsite.dataprovider.MenuDomainDataProvider;
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
    private MenuDomainDataProvider menuDomainDataProvider;
    @Autowired
    private DomainDataProvider domainDataProvider;
    @Autowired
    private MenuDataProvider menuDataProvider;

    @Override
    public MenuSiteDto save(UUID idMenu, UUID idSite) throws ApiProcessException {
        log.info("Realizando persistencia de Menusite ");
        MenuEntity menu = this.menuDataProvider.findMenuById(idMenu);
        DomainEntity site = this.domainDataProvider.findById(idSite);
        return MenuDomainTranslator.toMenuDomainDto(this.menuDomainDataProvider
                .save(MenuDomainTranslator.toMenuDomainEntity(menu, site)));
    }

    @Override
    public MenuSiteDto findById(UUID id) {
        log.info("Realizando busqueda de Menusite con id {}", id);
        return MenuDomainTranslator.toMenuDomainDto(this.menuDomainDataProvider.findById(id));
    }

    @Override
    public List<MenuSiteDto> finAll() {
        log.info("Realizando busqueda de todos los Menusite ");
        return MenuDomainTranslator.toListMenuDomainDto(this.menuDomainDataProvider.finAll());
    }

    @Override
    public void deleteById(UUID id) {
        log.info("Realizando borrado de Menusite con id {}", id);
        this.menuDomainDataProvider.deleteById(id);
    }

    @Override
    public List<MenuDto> findByDomainId(UUID id) {
        log.info("Realizando busqueda Menu x Site por siteId {}", id);
        return MenuDomainTranslator.toListMenuDto(this.menuDomainDataProvider.findByDomainId(id));
    }
}
