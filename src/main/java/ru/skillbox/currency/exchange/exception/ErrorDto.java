package ru.skillbox.currency.exchange.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

    private String error;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
