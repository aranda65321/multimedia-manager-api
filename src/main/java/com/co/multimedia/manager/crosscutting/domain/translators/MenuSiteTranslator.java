package com.co.multimedia.manager.crosscutting.domain.translators;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuSiteDto;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuSiteEntity;
import com.co.multimedia.manager.crosscutting.domain.entity.DomainEntity;

import java.util.ArrayList;
import java.util.List;

public class MenuSiteTranslator {


    public static List<MenuSiteDto> toListMenuSiteDto(List<MenuSiteEntity> menuSite) {
        List<MenuSiteDto> menusSiteDto = new ArrayList<>();
        menuSite.forEach(menu -> menusSiteDto.add(toMenuSiteDto(menu)));
        return menusSiteDto;
    }

    public static MenuSiteEntity toMenuSiteEntity(MenuEntity menu, DomainEntity site) {
        return MenuSiteEntity.builder()
                .menu(menu)
                .siteConfiguration(site)
                .build();
    }

    public static MenuSiteDto toMenuSiteDto(MenuSiteEntity menuSite) {
        return MenuSiteDto.builder()
                .id(menuSite.getId())
                .siteId(menuSite.getSiteConfiguration().getId())
                .nameSite(menuSite.getSiteConfiguration().getName())
                .menuId(menuSite.getMenu().getId())
                .nameMenu(menuSite.getMenu().getName())
                .build();
    }
}
