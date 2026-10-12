package com.example.jwtsecurity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuracion que lee las propiedades del application.yml
 * bajo el prefijo "jwt".
 *
 * CAMBIAR: si se agregan mas propiedades (issuer, audience, etc.), agregar los campos aqui.
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    // CAMBIAR: clave secreta, debe tener al menos 256 bits para HS256
    private String secret;

    // CAMBIAR: tiempo de expiracion del token en milisegundos
    private Long expiration;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }
}
