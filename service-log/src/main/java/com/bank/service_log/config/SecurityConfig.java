package com.bank.service_log.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Desactiva protección CSRF (útil para pruebas)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite todo sin autenticación
                );

        return http.build();
    }
}
