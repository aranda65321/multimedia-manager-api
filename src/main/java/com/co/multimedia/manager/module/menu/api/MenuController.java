package com.co.multimedia.manager.module.menu.api;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.domain.dto.MenuDto;
import com.co.multimedia.manager.crosscutting.exception.ApiProcessException;
import com.co.multimedia.manager.module.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity<ApiResponseDto> findMenuById(@RequestParam UUID id) throws ApiProcessException {
        return this.menuService.findMenuById(id);
    }

    @GetMapping("/findAll")
    public ResponseEntity<ApiResponseDto> findAllMenus() throws ApiProcessException {
        return this.menuService.findAllMenus();
    }

    @GetMapping("/findAll/child")
    public ResponseEntity<ApiResponseDto> findAllMenusWithChild() throws ApiProcessException {
        return this.menuService.findAllMenusWithChild();
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto> createMenu(@RequestBody MenuDto menuDto) throws ApiProcessException {
        return this.menuService.save(menuDto);
    }

    @PostMapping("/child")
    public ResponseEntity<ApiResponseDto> createMenuChild(@RequestBody MenuDto menuDto) throws ApiProcessException {
        return this.menuService.saveChild(menuDto);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseDto> deleteMenu(@RequestParam UUID id) throws ApiProcessException {
        return this.menuService.deleteMenuById(id);
    }


}
