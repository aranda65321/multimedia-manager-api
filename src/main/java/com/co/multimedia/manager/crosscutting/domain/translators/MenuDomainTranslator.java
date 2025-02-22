package com.co.multimedia.manager.crosscutting.domain.translators;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuSiteDto;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuSiteEntity;
import com.co.multimedia.manager.crosscutting.domain.entity.DomainEntity;

import java.util.ArrayList;
import java.util.List;

public class MenuSiteTranslator {


    public static List<MenuSiteDto> toListMenuDomainDto(List<MenuSiteEntity> menuSite) {
        List<MenuSiteDto> menusSiteDto = new ArrayList<>();
        menuSite.forEach(menu -> menusSiteDto.add(toMenuDomainDto(menu)));
        return menusSiteDto;
    }

    public static MenuSiteEntity toMenuDomainEntity(MenuEntity menu, DomainEntity site) {
        return MenuSiteEntity.builder()
                .menu(menu)
                .domain(site)
                .build();
    }

    public static MenuSiteDto toMenuDomainDto(MenuSiteEntity menuSite) {
        return MenuSiteDto.builder()
                .menu(MenuTranslator.toMenuDto(menuSite.getMenu()))
                .build();
    }
}
