package com.example.jwtsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicacion.
 *
 * AGREGAR: configuraciones adicionales si son necesarias (cors, timezones, etc.).
 */
@SpringBootApplication
public class JwtsecurityApplication {

    public static void main(String[] args) {
        System.out.println("Aplicacion iniciada...");
        SpringApplication.run(JwtsecurityApplication.class, args);
    }

}
