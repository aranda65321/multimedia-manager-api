package com.co.multimedia.manager.crosscutting.domain.translators;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuDto;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MenuTranslator {
    public static MenuEntity toMenuEntity(MenuDto menuDto) {
        return MenuEntity.builder()
                .name(menuDto.getName())
                .creationDate(LocalDateTime.now())
                .description(menuDto.getDescription())
                .iconClass(menuDto.getIconClass())
                .langCode(menuDto.getLangCode())
                .build();
    }

    public static List<MenuDto> toListMenuDto(List<MenuEntity> menus) {
        List<MenuDto> menusDto = new ArrayList<>();
        menus.forEach(menu -> menusDto.add(toMenuDto(menu)));
        return menusDto;
    }

    public static MenuDto toMenuDto(MenuEntity menuEntity) {
        return toMenuDto(menuEntity, new ArrayList<>());
    }

    public static MenuDto toMenuDto(MenuEntity menuEntity, List<MenuEntity> children) {
        MenuDto menu = MenuDto.builder()
                .id(menuEntity.getId())
                .name(menuEntity.getName())
                .creationDate(menuEntity.getCreationDate())
                .modificationDate(menuEntity.getModificationDate())
                .description(menuEntity.getDescription())
                .iconClass(menuEntity.getIconClass())
                .langCode(menuEntity.getLangCode())
                .build();
        if (menuEntity.getParentMenu() != null) {
            menu.setParent(toMenuDto(menuEntity.getParentMenu()));
        }
        menu.setChildren(toListMenuDto(children));
        return menu;
    }
}
