package com.co.multimedia.manager.module.domain.service.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.domain.dto.DomainDto;
import com.co.multimedia.manager.crosscutting.domain.enums.TypeError;
import com.co.multimedia.manager.crosscutting.domain.translators.ApiResponseTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.domain.service.DomainService;
import com.co.multimedia.manager.module.domain.usecase.DomainUseCase;
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
public class DomainServiceImpl implements DomainService {
    @Autowired
    private DomainUseCase domainUseCase;

    @Override
    public ResponseEntity<ApiResponseDto> findById(UUID id) throws ApiProcessException {
        try {
            DomainDto result = domainUseCase.findById(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_001);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> findAll() throws ApiProcessException {
        try {
            List<DomainDto> result = this.domainUseCase.findAll();
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_002);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> save(DomainDto domainDto) throws ApiProcessException {
        try {
            domainDto.setCreationDate(LocalDateTime.now());
            DomainDto result = this.domainUseCase.save(domainDto);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, result));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_003);
        }
    }

    @Override
    public ResponseEntity<ApiResponseDto> deleteById(UUID id) throws ApiProcessException {
        try {
            this.domainUseCase.deleteById(id);
            return ResponseEntity.ok(ApiResponseTranslator.toApiResponseDto(HttpStatus.OK, null));
        } catch (Exception ex) {
            throw new ApiProcessException(ex, TypeError.IR_004);
        }
    }


}

