package com.co.multimedia.manager.module.menu.usecase;

import com.co.multimedia.manager.crosscutting.domain.dto.MenuDto;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;

import java.util.List;
import java.util.UUID;

public interface MenuUseCase {
    public MenuDto saveMenu(MenuDto menu) throws ApiProcessException;

    public MenuDto findMenuById(UUID id);

    public List<MenuDto> finAllMenus();

    public void deleteMenuById(UUID id);

}
