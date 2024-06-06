package com.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.ReflectiveAccess;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
@ReflectiveAccess
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatGptResponse {

    public List<Choice> choices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Introspected
    @ReflectiveAccess
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Choice {

        public Integer index;
        public ChatGptMessage message;

    }
}
