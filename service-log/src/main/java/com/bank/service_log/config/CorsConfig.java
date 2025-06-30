package com.bank.service_log.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica a todas las rutas
                .allowedOrigins("*") // Permite todos los orígenes (frontend, Postman, etc.)
                .allowedMethods("*") // Permite todos los métodos HTTP
                .allowedHeaders("*"); // Permite todos los headers
    }
}
