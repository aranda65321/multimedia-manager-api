package com.co.multimedia.manager.module.domain.dataprovider;

import com.co.multimedia.manager.crosscutting.domain.entity.DomainEntity;

import java.util.List;
import java.util.UUID;

public interface DomainDataProvider {
    public DomainEntity findById(UUID id);

    public List<DomainEntity> findAll();

    public DomainEntity save(DomainEntity siteEntity);

    public void deleteById(UUID id);
}
