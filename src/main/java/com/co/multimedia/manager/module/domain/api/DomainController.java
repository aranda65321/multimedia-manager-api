package com.co.multimedia.manager.module.domain.api;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.domain.dto.DomainDto;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.domain.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/domain")
@CrossOrigin("*")
public class DomainController {

    @Autowired
    private DomainService domainService;

    @GetMapping
    public ResponseEntity<ApiResponseDto> findDomainConfigurationById(@RequestParam UUID id) throws ApiProcessException {
        return this.domainService.findById(id);
    }

    @GetMapping("findAll")
    public ResponseEntity<ApiResponseDto> findAllDomainConfigurations() throws ApiProcessException {
        return this.domainService.findAll();
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto> createDomain(@RequestBody DomainDto domainDto) throws ApiProcessException {
        return this.domainService.save(domainDto);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseDto> deleteDomain(@RequestParam UUID id) throws ApiProcessException {
        return this.domainService.deleteById(id);
    }
}
