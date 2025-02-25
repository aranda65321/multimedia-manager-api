package com.co.multimedia.manager.module.menu.dataprovider.impl;

import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;
import com.co.multimedia.manager.crosscutting.domain.repository.MenuRepository;
import com.co.multimedia.manager.module.menu.dataprovider.MenuDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MenuDataProviderImpl implements MenuDataProvider {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public MenuEntity saveMenu(MenuEntity menu) {
        return this.menuRepository.save(menu);
    }

    @Override
    public MenuEntity findMenuById(UUID id) {
        return this.menuRepository.findById(id).orElse(null);
    }

    @Override
    public List<MenuEntity> findAllMenus() {
        return this.menuRepository.findAll();
    }

    @Override
    public List<MenuEntity> findAllMenusByIdParent(UUID id) {
        return this.menuRepository.findByParentMenuId(id);
    }

    @Override
    public void deleteMenuById(UUID id) {
        this.menuRepository.deleteById(id);
    }
}
