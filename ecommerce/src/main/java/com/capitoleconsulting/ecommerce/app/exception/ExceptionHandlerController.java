package com.capitoleconsulting.ecommerce.app.exception;


import com.capitoleconsulting.ecommerce.app.config.ExceptionConfigs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ExceptionHandlerController {

    private final ExceptionConfigs exceptionConfigs;

    @ExceptionHandler(MyBusinessException.class)
    public ResponseEntity<Object> manejarMiExcepcion(MyBusinessException ex) {
        log.error(ExceptionConfigs.BUSINESS + ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionConfigs.getTiposExcepciones(ExceptionConfigs.BUSINESS) + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcion(Exception ex) {
        log.error(exceptionConfigs.getTiposExcepciones(ExceptionConfigs.SYSTEM) + ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionConfigs.getTiposExcepciones(ExceptionConfigs.SYSTEM) + ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        log.error(
                exceptionConfigs.getTiposExcepciones(ExceptionConfigs.SYSTEM)+
                        "error info : \n{}",
                errors
        );

        return ResponseEntity.badRequest().body(errors);
    }

}
