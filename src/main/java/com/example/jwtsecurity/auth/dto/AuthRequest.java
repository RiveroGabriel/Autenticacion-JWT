package com.example.jwtsecurity.auth.dto;

import javax.validation.constraints.NotBlank;

/**
 * DTO para la peticion de login/registro.
 *
 * CAMBIAR: agregar mas campos si el login requiere email, rol, etc.
 */
public class AuthRequest {

    @NotBlank(message = "El usuario no puede estar vacio")
    private String username;

    @NotBlank(message = "La contrasenia no puede estar vacia")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
