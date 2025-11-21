package com.franquicias.franquify;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server().url("/api").description("API Server")
                ))
                .info(new Info()
                        .title("Franquify API")
                        .description("Sistema de gestión de franquicias y sucursales")
                        .version("v1.0.0"));
    }
}