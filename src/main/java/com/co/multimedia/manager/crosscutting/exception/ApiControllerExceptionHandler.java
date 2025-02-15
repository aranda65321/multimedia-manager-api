package com.co.multimedia.manager.crosscutting.exception;

import com.co.multimedia.manager.crosscutting.domain.dto.ApiResponseDto;
import com.co.multimedia.manager.crosscutting.domain.translators.ApiResponseTranslator;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class ApiControllerExceptionHandler {

    @ExceptionHandler(value = {ApiProcessException.class})
    public ResponseEntity<ApiResponseDto> exceptionHandler(ApiProcessException ex) {
        log.info("ERROR::. {}", ex.getTypeError().getDescription());
        return new ResponseEntity<>(ApiResponseTranslator.toApiResponseDtoWithError(ex.getTypeError()),
                ex.getTypeError().getHttpCode());
    }
}
