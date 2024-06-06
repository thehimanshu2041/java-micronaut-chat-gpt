package com.chatgpt;

import com.chatgpt.core.openapi.ApiSecuritySchemes;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "${api.title}",
                version = "${api.version}",
                description = "${api.description}",
                license = @License(name = "${api.licence.name}", url = "${api.licence.url}"),
                contact = @Contact(url = "${api.contact.url}", name = "${api.contact.name}", email = "${api.contact.mail}")
        )
)
@ApiSecuritySchemes
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}