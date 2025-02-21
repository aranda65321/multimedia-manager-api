package com.co.multimedia.manager.module.domain.service;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.domain.dto.DomainDto;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface DomainService {
    public ResponseEntity<ApiResponseDto> findById(UUID id) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> findAll() throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> save(DomainDto domainDto) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> deleteById(UUID id) throws ApiProcessException;
}
