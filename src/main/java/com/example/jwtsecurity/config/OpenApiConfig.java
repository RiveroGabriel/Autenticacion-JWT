package com.example.jwtsecurity.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * Configuracion de Swagger / OpenAPI.
 *
 * Define el esquema de seguridad "bearerAuth" para que desde Swagger UI
 * se pueda probar el login, copiar el token y pegarlo en "Authorize".
 *
 * CAMBIAR: titulo, version y descripcion segun el proyecto.
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "JWT Security API",
                version = "1.0",
                description = "API de autenticacion con JWT para Java 8"
        )
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class OpenApiConfig {
}
