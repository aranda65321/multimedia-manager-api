package com.co.multimedia.manager.module.menu.usecase.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuDto;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;
import com.co.multimedia.manager.crosscutting.domain.translators.MenuTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.menu.dataprovider.MenuDataProvider;
import com.co.multimedia.manager.module.menu.usecase.MenuUseCase;
import com.co.multimedia.manager.module.menuxsite.dataprovider.MenuDomainDataProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
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
        log.info("Realizando persistencia de Menu con name: {}", menu.getName());
        return MenuTranslator.toMenuDto(this.menuDataProvider.saveMenu(MenuTranslator.toMenuEntity(menu)));
    }

    @Override
    public MenuDto saveMenuChild(MenuDto menu) throws ApiProcessException {
        log.info("Realizando persistencia de Menu hijo con name: {}", menu.getName());
        MenuEntity parent = this.menuDataProvider.findMenuById(menu.getParent().getId());
        if (parent != null) {
            MenuEntity save = MenuTranslator.toMenuEntity(menu);
            save.setParentMenu(parent);
            return MenuTranslator.toMenuDto(this.menuDataProvider.saveMenu(save));
        }
        return null;
    }

    @Override
    public MenuDto findMenuById(UUID id) {
        log.info("Realizando busqueda de Menu con id {}", id);
        return MenuTranslator.toMenuDto(this.menuDataProvider.findMenuById(id));
    }

    @Override
    public List<MenuDto> findAllMenus() {
        log.info("Realizando busqueda de todos los Menus con hijos");
        List<MenuDto> menusDto = MenuTranslator.toListMenuDto(this.menuDataProvider.findAllMenus());
        for (MenuDto menu : menusDto) {
            addChildrenToMenu(menu, menusDto);
        }
        cleanRepeatMenus(menusDto);
        return menusDto;
    }

    @Override
    public void deleteMenuById(UUID id) {
        log.info("Realizando borrado de Menu con id {}", id);
        this.menuDataProvider.deleteMenuById(id);
    }

    private List<MenuDto> addChildrenToMenu(MenuDto parent, List<MenuDto> menus) {
        for (MenuDto menuChild : menus) {
            if (menuChild.getParent() != null
                    && menuChild.getParent().getId().equals(parent.getId())) {
                parent.getChildren().add(menuChild);
            }
        }
        return menus;
    }

    private void cleanRepeatMenus(List<MenuDto> menusDto) {
        List<MenuDto> auxMenus = new ArrayList<>();
        for (int i = 0; i < menusDto.size(); i++) {
            for (int j = 0; j < menusDto.size(); j++) {
                if (!menusDto.get(j).getChildren().isEmpty()
                        && existIntoChild(menusDto.get(j).getChildren(), menusDto.get(i))) {
                    auxMenus.add(menusDto.get(i));
                }
            }
        }
        menusDto.removeAll(auxMenus);
    }

    private boolean existIntoChild(List<MenuDto> children, MenuDto menu) {
        for (MenuDto child : children) {
            if (menu.getId().equals(child.getId())) {
                return true;
            }
            if (!child.getChildren().isEmpty()) {
                existIntoChild(child.getChildren(), menu);
            }
        }
        return false;
    }


}
