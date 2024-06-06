package com.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.ReflectiveAccess;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
@ReflectiveAccess
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatGptMessage {

    public String role;
    public String content;
}
