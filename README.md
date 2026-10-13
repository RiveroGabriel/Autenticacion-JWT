# JWT Security Module

Modulo de autenticacion con **JWT** para Spring Boot.

Este proyecto esta preparado para **Java 8** y **Spring Boot 2.7.18**. Si el proyecto destino usa Java 17+/Spring Boot 3, hay que migrar la configuracion de seguridad a la API moderna (`SecurityFilterChain`, `jakarta.servlet`, etc.).

---

## Requisitos

- Java 8 o superior
- Maven

---

## Tecnologias principales

- Spring Boot 2.7.18
- Spring Security
- JJWT 0.11.5
- Springdoc OpenAPI / Swagger UI 1.8.0
- Lombok (opcional)

---

## Como levantar el proyecto

```bash
mvnw spring-boot:run
```

O si tenes Maven instalado:

```bash
mvn spring-boot:run
```

La aplicacion se levanta en:

```
http://localhost:8080
```

---

## Como probar con Swagger

1. Abrir en el navegador:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

2. Ir al endpoint `POST /api/auth/login` y probar con el usuario de prueba:
   ```json
   {
     "username": "admin",
     "password": "admin123"
   }
   ```

3. Copiar el token que devuelve.

4. Clic en el boton **Authorize** de Swagger y escribir:
   ```
   Bearer <token>
   ```

5. Ahora podes probar cualquier endpoint protegido.

---

## Endpoints

| Metodo | Endpoint          | Descripcion                              | Seguridad |
|--------|-------------------|------------------------------------------|-----------|
| POST   | `/api/auth/login` | Devuelve un JWT si las credenciales son validas | Publico   |
| POST   | `/api/auth/register` | Pendiente de implementacion           | Publico   |

---

## Cosas que hay que adaptar antes de usar en produccion

1. **Cambiar la clave secreta JWT**  
   Archivo: `src/main/resources/application.yml`  
   Propiedad: `jwt.secret`  
   Debe tener al menos 32 caracteres.

2. **Conectar el login a la base de datos real**  
   Archivo: `auth/service/CustomUserDetailsService.java`  
   Actualmente tiene un usuario hardcodeado (`admin` / `admin123`). Hay que reemplazarlo por la consulta al repositorio real.

3. **Implementar el registro**  
   Archivo: `auth/controller/AuthController.java` y `auth/service/AuthServiceImpl.java`  
   El metodo `register` solo devuelve un mensaje de prueba.

4. **Ajustar rutas publicas/privadas**  
   Archivo: `config/SecurityConfig.java`  
   Modificar los `antMatchers` segun los endpoints del proyecto.

5. **Cambiar el paquete base**  
   El paquete actual es `com.example.jwtsecurity`. Si se copia a otro proyecto, renombrar todas las carpetas y el `groupId`/`artifactId` del `pom.xml`.

---

## Estructura de carpetas

```
src/main/java/com/example/jwtsecurity/
├── JwtsecurityApplication.java
├── config/
│   ├── JwtProperties.java
│   ├── OpenApiConfig.java
│   ├── PasswordEncoderConfig.java
│   └── SecurityConfig.java
└── auth/
    ├── JwtAuthFilter.java
    ├── controller/
    │   └── AuthController.java
    ├── dto/
    │   ├── AuthRequest.java
    │   └── AuthResponse.java
    ├── model/
    │   └── User.java
    └── service/
        ├── AuthService.java
        ├── AuthServiceImpl.java
        ├── CustomUserDetailsService.java
        └── JwtService.java
```

---

## Nota importante sobre la version

Este modulo usa la API **antigua** de Spring Security 5.x porque Spring Boot 2.7.x no es compatible con la API moderna de Spring Boot 3:

| Concepto                | Spring Boot 2.7.x (Java 8)     | Spring Boot 3.x (Java 17+)  |
|-------------------------|--------------------------------|-----------------------------|
| Configuracion seguridad | `WebSecurityConfigurerAdapter` | `SecurityFilterChain`       |
| Filtros servlet         | `javax.servlet`                | `jakarta.servlet`           |
| Rutas                   | `antMatchers(...)`             | `requestMatchers(...)`      |

Si el proyecto destino usa Spring Boot 3, hay que migrar `SecurityConfig.java` y `JwtAuthFilter.java`.
