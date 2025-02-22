package com.co.multimedia.manager.module.domain.usecase.impl;

import com.co.multimedia.manager.crosscutting.domain.dto.DomainDto;
import com.co.multimedia.manager.crosscutting.domain.translators.DomainTranslator;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.domain.dataprovider.DomainDataProvider;
import com.co.multimedia.manager.module.domain.usecase.DomainUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@Log4j2
public class DomainUseCaseImpl implements DomainUseCase {
    @Autowired
    private DomainDataProvider domainDataProvider;

    @Override
    public DomainDto findById(UUID id) throws ApiProcessException {
        log.info("Realizando busqueda de Site con id {}", id);
        return DomainTranslator.toDomainDto(this.domainDataProvider.findById(id));
    }

    @Override
    public List<DomainDto> findAll() throws ApiProcessException {
        log.info("Realizando busqueda de todos los sites ");
        return DomainTranslator.toDomainsDto(this.domainDataProvider.findAll());
    }

    @Override
    public DomainDto save(DomainDto domainDto) throws ApiProcessException {
        log.info("Realizando persistencia de site con name: {}", domainDto.getName());
        domainDto.setCreationDate(LocalDateTime.now());
        return DomainTranslator.toDomainDto(this.domainDataProvider.save(DomainTranslator
                .toDomainEntity(domainDto)));
    }

    @Override
    public void deleteById(UUID id) throws ApiProcessException {
        log.info("Realizando borrado de site con id {}", id);
        this.domainDataProvider.deleteById(id);
    }
}
