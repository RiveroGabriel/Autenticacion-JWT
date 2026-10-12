package com.example.jwtsecurity.auth.model;

/**
 * Modelo de ejemplo de un usuario.
 *
 * TODO: CAMBIAR este modelo segun la entidad real del proyecto.
 * AGREGAR: anotaciones de JPA (@Entity, @Id, @GeneratedValue) si se usa base de datos.
 */
public class User {

    // CAMBIAR: tipo de dato segun la base de datos (Long, UUID, etc.)
    private Long id;

    private String username;

    private String password;

    // AGREGAR: campos adicionales (email, nombre, rol, activo, etc.)
    // private String email;
    // private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
