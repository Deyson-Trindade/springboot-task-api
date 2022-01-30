package com.notes.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class ExceptionResponseDTO {

    private final Date timestamp;
    private final String message;
    private final List<ErrorResponseDTO> errors;
    private final String path;

    public ExceptionResponseDTO(Date timestamp,  String path, String message, List<ErrorResponseDTO> errors) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.errors = errors;
        this.path = path;
    }
}
