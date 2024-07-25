package com.doenerbestelltool.service.doenerbestelltool.configuration;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {                                    
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");


        Info information = new Info()
                .title("Dönerbestell Tool Management API")
                .version("0.0.1-SNAPSHOT")
                .description("This API exposes endpoints to manage kebab orders.");
        return new OpenAPI().info(information).servers(List.of(server));
    }

}