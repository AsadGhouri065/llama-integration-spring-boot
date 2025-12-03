package com.integration.ai.generative.service;

import com.integration.ai.generative.dto.request.ChatRequestLocal;
import com.integration.ai.generative.dto.response.GenerateResponseLLM;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OllamaService {
    private final ChatModel chatModel;

    public OllamaService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public GenerateResponseLLM chat(ChatRequestLocal chatRequest) {
        var prompt = chatRequest
                .messages()
                .stream()
                .findFirst()
                .map(ChatRequestLocal.Message::content)
                .orElseThrow(() -> new NoSuchElementException("Messages cannot be empty"));

        var contentFromPrompt = chatModel.call(prompt);

        return new GenerateResponseLLM(
                "llama3.2",
                contentFromPrompt
        );
    }
}
