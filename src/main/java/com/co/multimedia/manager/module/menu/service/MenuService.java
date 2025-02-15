package com.co.multimedia.manager.module.menu.service;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.domain.dto.MenuDto;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface MenuService {

    public ResponseEntity<ApiResponseDto> findSiteById(UUID id) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> findAllSite() throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> save(MenuDto menuDto) throws ApiProcessException;

    public ResponseEntity<ApiResponseDto> deleteSiteById(UUID id) throws ApiProcessException;

}
