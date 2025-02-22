package com.co.multimedia.manager.module.menuxsite.service;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface MenuDomainService {
    public ResponseEntity<ApiResponseDto> findById(UUID id) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> findAll() throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> save(UUID idMenu, UUID idSite) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> deleteById(UUID id) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> findByDomainConfigurationEntityId(UUID id) throws ApiProcessException;

}
