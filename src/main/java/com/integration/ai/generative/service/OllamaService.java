package com.integration.ai.generative.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OllamaService {
    private final ChatModel chatModel;

    public OllamaService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public OllamaApi.ChatResponse chat(OllamaApi.ChatRequest chatRequest) {
        String prompt = chatRequest.messages().getFirst().content();
        String contentFromPrompt = chatModel.call(prompt);

        return new OllamaApi.ChatResponse(
                "llama3.2",
                Instant.now(),
                new OllamaApi.Message(
                        OllamaApi.Message.Role.USER,
                        contentFromPrompt,
                        null,
                        null, null, null
                ),
                "stop",
                true,
                0L,
                0L,
                0,
                0L,
                0,
                0L
        );
    }
}
