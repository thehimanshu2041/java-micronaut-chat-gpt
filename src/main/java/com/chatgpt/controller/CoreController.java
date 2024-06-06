package com.chatgpt.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;

@Controller()
@Slf4j
@Hidden
public class CoreController {

    @Get("/swagger")
    @View("swagger-ui/swagger")
    public HttpResponse<?> getSwagger() {
        return HttpResponse.ok();
    }
}