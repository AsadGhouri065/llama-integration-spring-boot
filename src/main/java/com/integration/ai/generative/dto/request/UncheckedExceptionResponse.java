package com.integration.ai.generative.dto.request;

import java.time.LocalDateTime;

public record UncheckedExceptionResponse(LocalDateTime timestamp,
                                         int status,
                                         String error,
                                         String message) {
}
