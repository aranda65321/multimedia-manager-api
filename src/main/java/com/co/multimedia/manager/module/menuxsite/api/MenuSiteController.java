package com.co.multimedia.manager.module.menuxsite.api;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.menuxsite.service.MenuSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/menusite")
@CrossOrigin("*")
public class MenuSiteController {

    @Autowired
    private MenuSiteService menuSiteService;

    @GetMapping
    public ResponseEntity<ApiResponseDto> findMenuById(@RequestParam UUID id) throws ApiProcessException {
        return this.menuSiteService.findById(id);
    }

    @GetMapping("/findAll")
    public ResponseEntity<ApiResponseDto> findAllMenus() throws ApiProcessException {
        return this.menuSiteService.findAll();
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto> createMenu(@RequestParam UUID idMenu, @RequestParam UUID idSite) throws ApiProcessException {
        return this.menuSiteService.save(idMenu, idSite);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseDto> deleteMenu(@RequestParam UUID id) throws ApiProcessException {
        return this.menuSiteService.deleteById(id);
    }

    @GetMapping("/findBySiteId")
    public ResponseEntity<ApiResponseDto> findBySiteId(@RequestParam UUID id) throws ApiProcessException {
        return this.menuSiteService.findBySiteConfigurationEntityId(id);
    }
}
