package com.chatgpt.service.impl;

import com.chatgpt.model.ChatGptResponse;
import com.chatgpt.service.client.ChatGptClient;
import com.chatgpt.service.ChatGptService;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class ChatGptServiceImpl implements ChatGptService {

    private final ChatGptClient chatGptClient;

    public ChatGptServiceImpl(ChatGptClient chatGptClient) {
        this.chatGptClient = chatGptClient;
    }

    @Override
    public ChatGptResponse chat(String content) {
        return chatGptClient.chat(content);
    }
}
