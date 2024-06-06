package com.chatgpt.core.exception.handler;

import com.chatgpt.core.exception.BusinessException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
@Produces
@Requires(classes = {BusinessException.class, ExceptionHandler.class})
public class BusinessExceptionHandler
        implements ExceptionHandler<BusinessException, HttpResponse<String>> {

    @Override
    public HttpResponse<String> handle(HttpRequest request, BusinessException exception) {
        return HttpResponse.serverError(exception.getMessage());
    }
}
