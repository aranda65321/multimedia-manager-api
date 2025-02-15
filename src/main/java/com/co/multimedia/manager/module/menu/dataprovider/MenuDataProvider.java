package com.co.multimedia.manager.module.menu.dataprovider;

import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;

import java.util.List;
import java.util.UUID;

public interface MenuDataProvider {

    public MenuEntity saveMenu(MenuEntity menu);

    public MenuEntity findMenuById(UUID id);

    public List<MenuEntity> finAllMenus();

    public void deleteMenuById(UUID id);
}
