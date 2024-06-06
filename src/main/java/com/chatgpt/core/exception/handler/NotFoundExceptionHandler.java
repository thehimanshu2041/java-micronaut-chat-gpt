package com.chatgpt.core.exception.handler;

import com.chatgpt.core.exception.NotFoundException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
@Produces
@Requires(classes = {NotFoundException.class, ExceptionHandler.class})
public class NotFoundExceptionHandler
        implements ExceptionHandler<NotFoundException, HttpResponse<String>> {

    @Override
    public HttpResponse<String> handle(HttpRequest request, NotFoundException exception) {
        return HttpResponse.notFound(exception.getMessage());
    }
}
