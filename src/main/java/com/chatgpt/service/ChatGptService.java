package com.chatgpt.service;

import com.chatgpt.model.ChatGptResponse;

public interface ChatGptService {

    ChatGptResponse chat(String content);
}
