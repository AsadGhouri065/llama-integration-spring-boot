package com.integration.ai.generative.controller;

import com.integration.ai.generative.service.OllamaService;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ollama")
public class OllamaController {

    private final OllamaService ollamaService;

    public OllamaController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/chat")
    public OllamaApi.ChatResponse chat(@RequestBody OllamaApi.ChatRequest chatRequest) {
        return ollamaService.chat(chatRequest);
    }
}
