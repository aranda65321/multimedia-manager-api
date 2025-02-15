package com.co.multimedia.manager.crosscutting.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class MenuSiteDto {
    private UUID id;
    private UUID siteId;
    private String nameSite;
    private UUID menuId;
    private String nameMenu;

}
