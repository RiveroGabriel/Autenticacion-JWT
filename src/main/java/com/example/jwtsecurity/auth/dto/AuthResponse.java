package com.example.jwtsecurity.auth.dto;

/**
 * DTO para la respuesta de autenticacion.
 *
 * CAMBIAR: agregar mas datos si se quiere devolver rol, expiracion, tipo de token, etc.
 */
public class AuthResponse {

    private String token;

    // AGREGAR: otros campos si son necesarios
    // private String tokenType;
    // private Long expiresIn;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
