package com.example.demo.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomExceptionHandler {

    private String message;
    private int status;
    private LocalDateTime timestamp;
}
