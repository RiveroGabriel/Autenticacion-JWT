package com.example.jwtsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuracion separada del PasswordEncoder.
 *
 * Se coloca en una clase aparte para evitar referencias circulares
 * entre SecurityConfig, JwtAuthFilter y CustomUserDetailsService.
 *
 * CAMBIAR: si se prefiere otro algoritmo, modificar aqui.
 */
@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
