package com.co.multimedia.manager.module.menuxsite.service.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.domain.dto.MenuSiteDto;
import com.co.multimedia.manager.crosscutting.domain.enums.TypeError;
import com.co.multimedia.manager.crosscutting.domain.translators.ApiResponseTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.menuxsite.service.MenuDomainService;
import com.co.multimedia.manager.module.menuxsite.usecase.MenuDomainUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuDomainServiceImpl implements MenuDomainService {

    @Autowired
    private MenuDomainUseCase menuDomainUseCase;

    @Override
    public ResponseEntity<ApiResponseDto> findById(UUID id) throws ApiProcessException {
        try {
            MenuSiteDto result = this.menuDomainUseCase.findById(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_009);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> findAll() throws ApiProcessException {
        try {
            List<MenuSiteDto> result = this.menuDomainUseCase.finAll();
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_010);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> save(UUID idMenu, UUID idSite) throws ApiProcessException {
        try {
            MenuSiteDto result = this.menuDomainUseCase.save(idMenu, idSite);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_011);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> deleteById(UUID id) throws ApiProcessException {
        try {
            this.menuDomainUseCase.deleteById(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, null));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_012);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> findBySiteConfigurationEntityId(UUID id) throws ApiProcessException {
        try {
            List<MenuSiteDto> result = this.menuDomainUseCase.findBySiteConfigurationEntityId(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_010);
        }
    }
}
