package com.co.multimedia.manager.crosscutting.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteConfigurationDto {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private String nameSite;
    private String iconPath;
    private String logoPath;
}
