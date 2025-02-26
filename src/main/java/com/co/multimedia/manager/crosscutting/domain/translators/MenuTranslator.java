package com.co.multimedia.manager.crosscutting.domain.translators;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuDto;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MenuTranslator {
    public static MenuEntity toMenuEntity(final MenuDto menuDto) {
        return MenuEntity.builder()
                .name(menuDto.getName())
                .creationDate(LocalDateTime.now())
                .description(menuDto.getDescription())
                .iconClass(menuDto.getIconClass())
                .langCode(menuDto.getLangCode())
                .build();
    }

    public static List<MenuDto> toListMenuDto(final List<MenuEntity> menus) {
        List<MenuDto> menusDto = new ArrayList<>();
        menus.forEach(menu -> menusDto.add(toMenuDto(menu)));
        return menusDto;
    }


    public static MenuDto toMenuDto(final MenuEntity menuEntity) {
        MenuDto menu = MenuDto.builder()
                .id(menuEntity.getId())
                .name(menuEntity.getName())
                .creationDate(menuEntity.getCreationDate())
                .modificationDate(menuEntity.getModificationDate())
                .description(menuEntity.getDescription())
                .iconClass(menuEntity.getIconClass())
                .langCode(menuEntity.getLangCode())
                .parent(menuEntity.getParentId())
                .children(new ArrayList<>())
                .build();
        if (menuEntity.getChildren() != null && menuEntity.getChildren().size() > 0) {
            for (MenuEntity menuChild : menuEntity.getChildren()) {
                menu.getChildren().add(toMenuDto(menuChild));
            }
        }
        return menu;
    }

    public static List<MenuEntity> cleanRepeatMenus(List<MenuEntity> menus) {
        List<MenuEntity> auxMenus = new ArrayList<>();
        for (int i = 0; i < menus.size(); i++) {
            for (int j = 0; j < menus.size(); j++) {
                if (!menus.get(j).getChildren().isEmpty()
                        && existIntoChild(menus.get(j).getChildren(), menus.get(i))) {
                    auxMenus.add(menus.get(i));
                }
            }
        }
        menus.removeAll(auxMenus);
        return menus;
    }

    private static boolean existIntoChild(List<MenuEntity> children, MenuEntity menu) {
        for (MenuEntity child : children) {
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
