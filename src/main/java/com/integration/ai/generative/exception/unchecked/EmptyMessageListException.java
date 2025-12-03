package com.integration.ai.generative.exception.unchecked;

public class EmptyMessageListException extends RuntimeException {
    public EmptyMessageListException(String message) {
        super(message);
    }
}
