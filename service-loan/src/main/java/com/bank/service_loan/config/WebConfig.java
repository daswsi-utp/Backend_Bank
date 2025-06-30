package com.bank.service_loan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica a todas las rutas
                .allowedOrigins("*") // Permite cualquier origen
                .allowedMethods("*") // Permite todos los métodos (GET, POST, PUT, DELETE...)
                .allowedHeaders("*") // Permite cualquier encabezado
                .allowCredentials(false); // No requiere credenciales
    }
}
