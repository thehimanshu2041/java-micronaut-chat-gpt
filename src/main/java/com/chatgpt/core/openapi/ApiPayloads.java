package com.chatgpt.core.openapi;

import io.micronaut.http.MediaType;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "401",
                description = "Unauthorized",
                content = @Content(
                        mediaType = MediaType.TEXT_PLAIN,
                        schema = @Schema(implementation = String.class))),
        @ApiResponse(
                responseCode = "404",
                description = "Not Found",
                content = @Content(
                        mediaType = MediaType.TEXT_PLAIN,
                        schema = @Schema(implementation = String.class))),
        @ApiResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = @Content(mediaType = MediaType.TEXT_PLAIN,
                        schema = @Schema(implementation = String.class)))})
public @interface ApiPayloads {
}
