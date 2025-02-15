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

    @ManyToOne
    @JoinColumn(name = "fk_menu_parent", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_menu_parent"))
    private MenuEntity parentMenu;

}
