package com.chatgpt.service.client;

import com.chatgpt.core.exception.BusinessException;
import com.chatgpt.model.ChatGPTRequest;
import com.chatgpt.model.ChatGptMessage;
import com.chatgpt.model.ChatGptResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@Singleton
public class ChatGptClient {

    @Value("${chat-gpt.chat.model}")
    private String chatModel;

    @Value(("${chat-gpt.chat.url}"))
    private String chatUrl;

    @Value(("${chat-gpt.secret-key}"))
    private String secretKey;

    private final ObjectMapper objectMapper;

    public ChatGptClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ChatGptResponse chat(String content) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(chatUrl))
                    .setHeader("Authorization", "Bearer " + secretKey)
                    .setHeader("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(
                            objectMapper.writeValueAsString(ChatGPTRequest.builder()
                                    .model(chatModel)
                                    .messages(Collections.singletonList(ChatGptMessage.builder().role("user").content(content).build()))
                                    .build()))).build();

            HttpClient client = HttpClient.newHttpClient();
            CompletableFuture<HttpResponse<String>> responseFuture = client
                    .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> response = responseFuture.get();
            if (response.statusCode() != 200 || null == response.body()) {
                throw new BusinessException("Error when calling api : " + response.body());
            }
            return objectMapper.readValue(response.body(), ChatGptResponse.class);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }
}
