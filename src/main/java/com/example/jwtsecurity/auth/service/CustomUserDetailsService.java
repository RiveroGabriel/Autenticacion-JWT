package com.example.jwtsecurity.auth.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Servicio que carga los datos del usuario para Spring Security.
 *
 * TODO: CAMBIAR este ejemplo fijo por una consulta real a la base de datos
 * o al repositorio de usuarios del proyecto.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //
        // CAMBIAR: buscar el usuario en la base de datos usando el repositorio.
        // Ejemplo:
        // UserEntity user = userRepository.findByUsername(username)
        //     .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        //

        // Ejemplo temporal con usuario "admin" / "admin123"
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        // AGREGAR: roles y permisos reales del usuario
        return new User(
                "admin",
                passwordEncoder.encode("admin123"),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
