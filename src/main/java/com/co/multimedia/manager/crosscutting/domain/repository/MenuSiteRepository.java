package com.co.multimedia.manager.crosscutting.domain.repository;

import com.co.multimedia.manager.crosscutting.domain.entity.MenuSiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuSiteRepository extends JpaRepository<MenuSiteEntity, UUID> {

    List<MenuSiteEntity> findBySiteConfigurationId(UUID id);

}
