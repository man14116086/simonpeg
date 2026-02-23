package com.simonpeg.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    // http://localhost:7081/simonpeg/swagger-ui/index.html

    @Bean
    public OpenAPI appBasiliskOpenApi(){
        String schemaName = "bearerAuth";
        SecurityRequirement requirement = new SecurityRequirement().addList(schemaName);

        SecurityScheme scheme = new SecurityScheme()
                                .name(schemaName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT");

        Components components = new Components().addSecuritySchemes(schemaName, scheme);

        Info info = new Info().title("App SIMONPEG Open API")
                .version("v 1.0.0")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));

        OpenAPI openAPI = new OpenAPI().addSecurityItem(requirement).components(components).info(info);

        return openAPI;
    }
}
