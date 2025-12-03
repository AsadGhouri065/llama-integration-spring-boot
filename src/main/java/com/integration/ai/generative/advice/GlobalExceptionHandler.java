package com.integration.ai.generative.advice;

import com.integration.ai.generative.dto.request.UncheckedExceptionResponse;
import com.integration.ai.generative.exception.unchecked.EmptyMessageListException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmptyMessageListException.class)
    public ResponseEntity<UncheckedExceptionResponse> handleEmptyMessageList(EmptyMessageListException emptyMessageListException) {
        var errorResponse = new UncheckedExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Server Encountered Empty Messages List",
                emptyMessageListException.getMessage());

        return ResponseEntity.badRequest().body(errorResponse);
    }
}

