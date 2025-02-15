package com.co.multimedia.manager.crosscutting.domain.repository;

import com.co.multimedia.manager.crosscutting.domain.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, UUID> {
}
