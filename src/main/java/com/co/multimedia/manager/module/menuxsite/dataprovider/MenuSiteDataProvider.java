package com.co.multimedia.manager.module.menuxsite.dataprovider;

import com.co.multimedia.manager.crosscutting.domain.entity.MenuSiteEntity;

import java.util.List;
import java.util.UUID;

public interface MenuSiteDataProvider {
    public MenuSiteEntity save(MenuSiteEntity menu);

    public MenuSiteEntity findById(UUID id);

    public List<MenuSiteEntity> finAll();

    public void deleteById(UUID id);
}
