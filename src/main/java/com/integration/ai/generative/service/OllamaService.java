package com.integration.ai.generative.service;

import com.integration.ai.generative.dto.request.ChatRequestLocal;
import com.integration.ai.generative.dto.response.ChatResponseLocal;
import com.integration.ai.generative.exception.unchecked.EmptyMessageListException;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OllamaService {
    private final ChatModel chatModel;

    public OllamaService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public ChatResponseLocal chat(ChatRequestLocal chatRequestLocal) {
        var prompt = chatRequestLocal
                .messages()
                .stream()
                .findFirst()
                .map(ChatRequestLocal.Message::content)
                .orElseThrow(() -> new EmptyMessageListException("Messages cannot be empty"));

        var contentFromPrompt = chatModel.call(prompt);

        return new ChatResponseLocal(
                "llama3.2",
                contentFromPrompt
        );
    }
}
