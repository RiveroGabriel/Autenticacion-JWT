package com.example.jwtsecurity.auth.controller;

import com.example.jwtsecurity.auth.dto.AuthRequest;
import com.example.jwtsecurity.auth.dto.AuthResponse;
import com.example.jwtsecurity.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controlador de autenticacion.
 *
 * CAMBIAR: agregar endpoints adicionales segun las necesidades (refresh token, logout, etc.).
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Endpoint de login.
     * Devuelve un JWT si las credenciales son correctas.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        // CAMBIAR: agregar manejo de excepciones personalizado si se desea
        return ResponseEntity.ok(authService.login(request));
    }

    /**
     * Endpoint de registro.
     * AGREGAR: implementar logica de registro real con persistencia.
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody AuthRequest request) {
        // TODO: implementar registro de usuarios
        return ResponseEntity.ok("Usuario registrado (pendiente de implementacion)");
    }
}
