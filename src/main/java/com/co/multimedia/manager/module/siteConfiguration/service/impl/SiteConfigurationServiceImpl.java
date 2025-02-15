package com.co.multimedia.manager.module.siteConfiguration.service.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.domain.dto.SiteConfigurationDto;
import com.co.multimedia.manager.crosscutting.domain.enums.TypeError;
import com.co.multimedia.manager.crosscutting.domain.translators.ApiResponseTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.siteConfiguration.service.SiteConfigurationService;
import com.co.multimedia.manager.module.siteConfiguration.usecase.SiteConfigurationUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class SiteConfigurationServiceImpl implements SiteConfigurationService {
    @Autowired
    private SiteConfigurationUseCase siteConfigurationUseCase;

    @Override
    public ResponseEntity<ApiResponseDto> findSiteById(UUID id) throws ApiProcessException {
        try {
            SiteConfigurationDto result = siteConfigurationUseCase.findSiteById(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_001);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> findAllSite() throws ApiProcessException {
        try {
            List<SiteConfigurationDto> result = this.siteConfigurationUseCase.findAllSite();
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_002);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> save(SiteConfigurationDto siteConfigurationDto) throws ApiProcessException {
        try {
            siteConfigurationDto.setCreationDate(LocalDateTime.now());
            SiteConfigurationDto result = this.siteConfigurationUseCase.save(siteConfigurationDto);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_003);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> deleteSiteById(UUID id) throws ApiProcessException {
        try {
            this.siteConfigurationUseCase.deleteSiteById(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, null));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_004);
        }
    }


}

