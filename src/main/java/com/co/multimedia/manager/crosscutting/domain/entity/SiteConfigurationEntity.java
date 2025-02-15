package com.co.multimedia.manager.crosscutting.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "GLOBAL_CONFIGURATION", name = "site_configuration")
public class SiteConfigurationEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "modification_date")
    private LocalDateTime modificationDate;
    @Column(name = "name_site")
    private String pageName;
    @Column(name = "icon_path")
    private String iconPath;
    @Column(name = "logo_path")
    private String logoPath;
}
