package com.co.multimedia.manager.crosscutting.domain.enums;

import org.springframework.http.HttpStatus;

public enum TypeError {
    IR_001("IR_001", "Error consultado site configuation por id", HttpStatus.NOT_FOUND),

    IR_002("IR_002", "Error consultando todos los sites configurations", HttpStatus.NOT_FOUND),

    IR_003("IR_003", "Error persistiendo site configuation", HttpStatus.CONFLICT),

    IR_004("IR_004", "Error suprimiendo site", HttpStatus.CONFLICT),
    IR_005("IR_005", "Error consultado Menu por id", HttpStatus.CONFLICT),
    IR_006("IR_006", "Error consultando todos los Menus", HttpStatus.CONFLICT),
    IR_007("IR_007", "Error persistiendo Menu", HttpStatus.CONFLICT),
    IR_008("IR_008", "Error suprimiendo Menu", HttpStatus.CONFLICT),
    IR_009("IR_009", "Error consultado MenuSite por id", HttpStatus.CONFLICT),
    IR_010("IR_010", "Error consultando todos los MenuSite", HttpStatus.CONFLICT),
    IR_011("IR_011", "Error persistiendo MenuSite", HttpStatus.CONFLICT),
    IR_012("IR_012", "Error suprimiendo MenuSite", HttpStatus.CONFLICT);

    private String code;
    private String description;

    private HttpStatus httpCode;

    TypeError(String code, String description, HttpStatus httpCode) {
        this.code = code;
        this.description = description;
        this.httpCode = httpCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HttpStatus getHttpCode() {
        return httpCode;
    }
}
