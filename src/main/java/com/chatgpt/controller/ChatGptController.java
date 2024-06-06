package com.chatgpt.controller;

import com.chatgpt.core.openapi.ApiPayloads;
import com.chatgpt.model.ChatGptResponse;
import com.chatgpt.service.ChatGptService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@Controller("/chat-gpt")
@Slf4j
public class ChatGptController {

    private final ChatGptService chatGptService;

    public ChatGptController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @Get("/chat/{content}")
    @ApiPayloads
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Chat Gpt",
            description = "Chat Gpt")
    @ApiResponse(
            responseCode = "200",
            description = "Operation Successful",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = ChatGptResponse.class)))
    public ChatGptResponse chat(@PathVariable String content) {
        return chatGptService.chat(content);
    }
}
