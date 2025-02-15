package com.co.multimedia.manager.module.menu.service.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.domain.dto.MenuDto;
import com.co.multimedia.manager.crosscutting.domain.enums.TypeError;
import com.co.multimedia.manager.crosscutting.domain.translators.ApiResponseTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.menu.service.MenuService;
import com.co.multimedia.manager.module.menu.usecase.MenuUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuUseCase menuUseCase;

    @Override
    public ResponseEntity<ApiResponseDto> findSiteById(UUID id) throws ApiProcessException {
        try {
            MenuDto result = this.menuUseCase.findMenuById(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_005);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> findAllSite() throws ApiProcessException {
        try {
            List<MenuDto> result = this.menuUseCase.finAllMenus();
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_006);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> save(MenuDto menuDto) throws ApiProcessException {
        try {
            menuDto.setCreationDate(LocalDateTime.now());
            MenuDto result = this.menuUseCase.saveMenu(menuDto);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_007);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> deleteSiteById(UUID id) throws ApiProcessException {
        try {
            this.menuUseCase.deleteMenuById(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, null));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_008);
        }
    }


}
