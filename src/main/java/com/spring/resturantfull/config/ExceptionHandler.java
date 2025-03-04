package com.spring.resturantfull.config;


import com.spring.resturantfull.service.BundleService.BundleTranslatorService;
import com.spring.resturantfull.service.Dtos.BundelMesssage.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.ok(new ExceptionResponseDto(HttpStatus.NO_CONTENT, BundleTranslatorService.getBundleMessageinEnglishAndArabic(ex.getMessage())));

    }



}
