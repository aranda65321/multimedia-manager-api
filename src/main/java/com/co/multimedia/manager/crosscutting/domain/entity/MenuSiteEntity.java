package com.co.multimedia.manager.crosscutting.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "GLOBAL_CONFIGURATION", name = "site_x_menu")
public class MenuSiteEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "fk_site_configuration", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_site_configuration"))
    private DomainEntity siteConfiguration;

    @ManyToOne
    @JoinColumn(name = "fk_menu", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_menu"))
    private MenuEntity menu;
}
