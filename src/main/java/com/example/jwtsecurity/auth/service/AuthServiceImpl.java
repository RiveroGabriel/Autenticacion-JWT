package com.example.jwtsecurity.auth.service;

import com.example.jwtsecurity.auth.dto.AuthRequest;
import com.example.jwtsecurity.auth.dto.AuthResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Implementacion del servicio de autenticacion.
 *
 * CAMBIAR: adaptar la logica si se usan otros mecanismos de autenticacion.
 */
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           JwtService jwtService,
                           CustomUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        // Autenticar usuario/contrasenia
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // Si la autenticacion fue exitosa, obtener el UserDetails
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Generar el token JWT
        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(token);
    }
}
