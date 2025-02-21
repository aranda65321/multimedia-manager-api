package com.co.multimedia.manager.module.domain.dataprovider.impl;

import com.co.multimedia.manager.crosscutting.domain.entity.DomainEntity;
import com.co.multimedia.manager.crosscutting.domain.repository.DomainRepository;
import com.co.multimedia.manager.module.domain.dataprovider.DomainDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DomainDataProviderImpl implements DomainDataProvider {
    @Autowired
    private DomainRepository domainRepository;

    @Override
    public DomainEntity findById(UUID id) {
        return this.domainRepository.findById(id).orElse(null);
    }

    @Override
    public List<DomainEntity> findAll() {
        return this.domainRepository.findAll();
    }

    @Override
    public DomainEntity save(DomainEntity siteEntity) {
        return this.domainRepository.save(siteEntity);
    }

    @Override
    public void deleteById(UUID id) {
        this.domainRepository.deleteById(id);
    }
}
