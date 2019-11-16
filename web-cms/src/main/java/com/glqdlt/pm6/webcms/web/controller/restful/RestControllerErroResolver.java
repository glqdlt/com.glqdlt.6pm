package com.glqdlt.pm6.webcms.web.controller.restful;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
@Slf4j
@RestControllerAdvice
public class RestControllerErroResolver {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity allErrorWappingHandler(Throwable e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
