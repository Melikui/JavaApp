package com.today.App.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("myToday 接口文档")
                        .description("@Author Melikui")
                        .version("v1"))
                .externalDocs(new ExternalDocumentation()
                        .description("主页")
                        .url("/"));
    }
}