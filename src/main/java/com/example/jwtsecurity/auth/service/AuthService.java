package com.example.jwtsecurity.auth.service;

import com.example.jwtsecurity.auth.dto.AuthRequest;
import com.example.jwtsecurity.auth.dto.AuthResponse;

/**
 * Interfaz del servicio de autenticacion.
 *
 * CAMBIAR: agregar metodos adicionales si se requiere refresh token, registro, etc.
 */
public interface AuthService {

    AuthResponse login(AuthRequest request);
}
