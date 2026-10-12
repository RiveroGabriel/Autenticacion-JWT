package com.example.jwtsecurity.config;

import com.example.jwtsecurity.auth.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuracion principal de Spring Security.
 *
 * NOTA: En Spring Boot 2.7.x con Java 8 se extiende WebSecurityConfigurerAdapter.
 * CAMBIAR: las rutas publicas y privadas segun las necesidades del proyecto.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthFilter jwtAuthFilter;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter,
                          UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Bean para el AuthenticationManager, necesario en el login.
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Configura el proveedor de usuarios.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    /**
     * Configura las reglas de seguridad HTTP.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Desactivar CSRF porque usamos tokens JWT (stateless)
            .csrf().disable()
            // Sin estado de sesion
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            // Autorizacion de rutas
            .authorizeRequests()
                // CAMBIAR: agregar aqui las rutas publicas del proyecto
                .antMatchers("/api/auth/**").permitAll()
                // Rutas publicas de Swagger / OpenAPI
                .antMatchers(
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**",
                        "/v3/api-docs",
                        "/swagger-resources/**",
                        "/webjars/**"
                ).permitAll()
                // Cualquier otra peticion requiere autenticacion
                .anyRequest().authenticated()
            .and()
            // AGREGAR: manejadores de excepciones personalizados si se desea
            // .exceptionHandling().authenticationEntryPoint(...).accessDeniedHandler(...)
            // .and()
            // Agregar el filtro JWT antes del filtro de autenticacion de usuario/contrasenia
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
