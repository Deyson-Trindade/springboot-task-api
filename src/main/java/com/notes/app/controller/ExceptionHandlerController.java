package com.notes.app.controller;

import com.notes.app.dto.ErrorResponseDTO;
import com.notes.app.dto.ExceptionResponseDTO;
import com.notes.app.exception.ExceptionGeneric;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Log4j2
@ControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(ExceptionGeneric.class)
    public ResponseEntity<ExceptionResponseDTO> handleGeneric(ExceptionGeneric exception, HttpServletRequest request) {
        log.error(exception);
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO("Generic Exception", exception.getLocalizedMessage());
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(new Date(), request.getRequestURI(),
                exception.getMessage(), List.of(errorResponseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleAll(Exception exception, HttpServletRequest request) {
        log.error(exception);
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO("", exception.getLocalizedMessage());
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(new Date(), request.getRequestURI(),
                exception.getMessage(), List.of(errorResponseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
