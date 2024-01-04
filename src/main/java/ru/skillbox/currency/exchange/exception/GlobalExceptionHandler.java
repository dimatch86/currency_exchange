package ru.skillbox.currency.exchange.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<ErrorDto> handleCurrencyNotFoundException(Exception e) {
        ErrorDto errorResponse = ErrorDto.builder()
                .error(e.getLocalizedMessage()).build();
        log.warn(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ReadDataException.class)
    public ResponseEntity<ErrorDto> handleReadDataException(Exception e) {
        ErrorDto errorResponse = ErrorDto.builder()
                .error(e.getLocalizedMessage()).build();
        log.warn(e.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
    }
}
