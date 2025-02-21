package com.co.multimedia.manager.module.domain.usecase;

import com.co.multimedia.manager.crosscutting.domain.dto.DomainDto;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;

import java.util.List;
import java.util.UUID;

public interface DomainUseCase {
    public DomainDto findById(UUID id) throws ApiProcessException;

    public List<DomainDto> findAll() throws ApiProcessException;

    public DomainDto save(DomainDto domainDto) throws ApiProcessException;

    public void deleteById(UUID id) throws ApiProcessException;
}
