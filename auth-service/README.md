# 🧩 Auth-Service – Wallet App

## 📝 Descripción

El **Auth-Service** es un microservicio encargado de la **gestión de usuarios y autenticación** dentro de la aplicación **Wallet-App**.  
Es responsable del registro, autenticación, manejo de roles y validación de credenciales.  
Además, incorpora **prácticas de concurrencia, programación funcional y auditoría** para mejorar el rendimiento y la mantenibilidad del sistema.

---

## ⚙️ Tecnologías utilizadas

- ☕ **Java 21**
- 🚀 **Spring Boot 3 (Web, Data JPA, Validation)**
- 🧩 **Lombok** para simplificar el código boilerplate
- 🧠 **H2 Database** (modo desarrollo)
- 🐘 **PostgreSQL** (modo producción / contenedor Docker)
- 🧰 **Maven** para construcción
- 🐳 **Docker** para contenerización

---

## 🧠 Características clave

✅ Registro y login de usuarios  
✅ Manejo de roles: `USER`, `ADMIN`, `MODERATOR`  
✅ Validación de credenciales  
✅ Contraseñas seguras con validaciones personalizadas  
✅ Auditoría automática de creación y actualización  
✅ Uso de **Thread** y **ExecutorService** para tareas asíncronas (notificaciones o logs)  
✅ Implementación de **Streams** y **Lambdas** para manipulación eficiente de datos  
✅ Excepciones personalizadas para errores de negocio  
✅ Respuesta estandarizada mediante DTOs y Mappers

---

## 🧩 Arquitectura interna

auth-service/
├── advice/
│ └── GlobalExceptionHandler.java
├── audit/
│ └── Auditable.java
├── controller/
│ └── AuthController.java
├── dto/
│ ├── RegisterRequest.java
│ ├── LoginRequest.java
│ └── UserResponse.java
├── exception/
│ └── EmailAlreadyExistsException.java
├── mapper/
│ └── UserMapper.java
├── model/
│ └── User.java
├── security/
│ └── Roles.java
├── repository/
│ └── UserRepository.java
├── service/
│ └── AsyncNotificationService.java
│ └── UserService.java
│ └── UserValidationService.java


---

##Configuración de la base de datos

**Modo H2 (por defecto en desarrollo)**

properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update

**Modo PostgreSQL (producción / Docker)**

spring.datasource.url=jdbc:postgresql://postgres:5432/wallet_db
spring.datasource.username=walletuser
spring.datasource.password=walletpass
spring.jpa.hibernate.ddl-auto=update


Cómo ejecutar el microservicio
Usando Maven

mvn clean package
java -jar target/auth-service-0.0.1-SNAPSHOT.jar


Usando Docker

docker build -t auth-service .
docker run -p 8080:8080 --name auth-service auth-service


🧩 Validaciones y seguridad

Email único por usuario

Contraseña segura:

≥ 8 caracteres

1 mayúscula, 1 minúscula, 1 número, 1 símbolo especial

Rol asignado automáticamente: USER por defecto

Excepciones personalizadas para errores de validación o duplicidad

Estado actual del microservicio

✅ Registro y login funcional
✅ Roles y validaciones aplicadas
✅ Implementación de Streams, Lambdas y Threads
✅ Auditoría de acciones de usuario
🚧 Próximos pasos: integración con Wallet-Service

💬 Autor

👤 Gabriel Di Gallo
📦 Proyecto educativo y de portafolio personal — arquitectura de microservicios Java