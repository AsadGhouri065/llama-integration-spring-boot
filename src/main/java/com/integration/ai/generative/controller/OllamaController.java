package com.integration.ai.generative.controller;

import com.integration.ai.generative.dto.request.ChatRequestLocal;
import com.integration.ai.generative.dto.response.ChatResponseLocal;
import com.integration.ai.generative.service.OllamaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/model")
public class OllamaController {

    private final OllamaService ollamaService;

    public OllamaController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/chat")
    public ChatResponseLocal chat(@RequestBody ChatRequestLocal chatRequestLocal) {
        return ollamaService.chat(chatRequestLocal);
    }
}
