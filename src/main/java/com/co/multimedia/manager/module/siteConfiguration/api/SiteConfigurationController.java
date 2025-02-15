package com.co.multimedia.manager.module.siteConfiguration.api;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.domain.dto.SiteConfigurationDto;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.siteConfiguration.service.SiteConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/site")
@CrossOrigin("*")
public class SiteConfigurationController {

    @Autowired
    private SiteConfigurationService siteConfigurationService;

    @GetMapping
    public ResponseEntity<ApiResponseDto> findSiteConfigurationById(@RequestParam UUID id) throws ApiProcessException {
        return this.siteConfigurationService.findSiteById(id);
    }

    @GetMapping("findAll")
    public ResponseEntity<ApiResponseDto> findAllSiteConfigurations() throws ApiProcessException {
        return this.siteConfigurationService.findAllSite();
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto> createSite(@RequestBody SiteConfigurationDto siteConfigurationDto) throws ApiProcessException {
        return this.siteConfigurationService.save(siteConfigurationDto);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseDto> deleteSite(@RequestParam UUID id) throws ApiProcessException {
        return this.siteConfigurationService.deleteSiteById(id);
    }
}
