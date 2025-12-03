package com.integration.ai.generative.dto.request;

import java.util.List;

public record ChatRequestLocal(
        List<Message> messages
) {
    public record Message(
            String role,
            String content
    ) {
    }
}


