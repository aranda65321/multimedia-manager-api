package com.co.multimedia.manager.module.menu.usecase.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuDto;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuSiteEntity;
import com.co.multimedia.manager.crosscutting.domain.translators.MenuTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.menu.dataprovider.MenuDataProvider;
import com.co.multimedia.manager.module.menu.usecase.MenuUseCase;
import com.co.multimedia.manager.module.menuxsite.dataprovider.MenuDomainDataProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Log4j2
public class MenuUseCaseImpl implements MenuUseCase {
    @Autowired
    private MenuDataProvider menuDataProvider;

    @Autowired
    private MenuDomainDataProvider menuDomainDataProvider;

    @Override
    public MenuDto saveMenu(MenuDto menu) throws ApiProcessException {
        log.info("Realizando persistencia de site con name: {}", menu.getName());
        return MenuTranslator.toMenuDto(this.menuDataProvider.saveMenu(MenuTranslator.toMenuEntity(menu)));
    }

    @Override
    public MenuDto findMenuById(UUID id) {
        log.info("Realizando busqueda de Site con id {}", id);
        return MenuTranslator.toMenuDto(this.menuDataProvider.findMenuById(id));
    }

    @Override
    public List<MenuDto> findAllMenus() {
        log.info("Realizando busqueda de todos los Menus ");
        return MenuTranslator.toListMenuDto(this.menuDataProvider.finAllMenus());
    }

    @Override
    public void deleteMenuById(UUID id) {
        log.info("Realizando borrado de site con id {}", id);
        this.menuDataProvider.deleteMenuById(id);
    }


}
