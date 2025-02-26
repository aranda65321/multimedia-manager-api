package com.co.multimedia.manager.crosscutting.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(schema = "GLOBAL_CONFIGURATION", name = "menu")
public class MenuEntity {
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
    @Column(name = "lang_code")
    private String langCode;
    @Column(name = "icon_class")
    private String iconClass;

    @Column(name = "fk_menu_parent")
    private UUID parentId;

    @Transient
    private List<MenuEntity> children;

}
