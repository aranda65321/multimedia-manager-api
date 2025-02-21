package com.co.multimedia.manager.module.menuxsite.usecase;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuSiteDto;
import com.co.multimedia.manager.crosscutting.domain.entity.MenuSiteEntity;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;

import java.util.List;
import java.util.UUID;

public interface MenuSiteUseCase {

    public MenuSiteDto save(UUID idMenu, UUID idSite) throws ApiProcessException;

    public MenuSiteDto findById(UUID id);

    public List<MenuSiteDto> finAll();

    public void deleteById(UUID id);

    public List<MenuSiteDto> findBySiteConfigurationEntityId(UUID id);
}
