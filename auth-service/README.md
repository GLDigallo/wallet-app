Auth-Service – Wallet App

**Descripción

El Auth-Service es un microservicio encargado de gestión de usuarios y autenticación dentro de la aplicación Wallet.
Permite:

Registro y login de usuarios.

Manejo de roles (USER, ADMIN, MODERATOR).

Validación de credenciales y control de acceso.

Este microservicio sirve como base para la seguridad de otros microservicios que se integrarán en el futuro.

**Tecnologías

Java 21

Spring Boot (Web, Data JPA, Validation)

Lombok

H2 Database (in-memory)

PostgreSQL (opcional, contenedor Docker)

Maven para construcción del proyecto

Docker para contenerización

**Configuración de la base de datos

El microservicio soporta dos modos de base de datos:

H2 (in-memory, para desarrollo rápido)

Acceso a la consola H2: /h2-console

Configuración en application.properties:
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update


PostgreSQL (recomendado para producción, con Docker)

Variables de entorno para conectarse al contenedor Docker:
spring.datasource.url=jdbc:postgresql://postgres:5432/wallet_db
spring.datasource.username=walletuser
spring.datasource.password=walletpass
spring.jpa.hibernate.ddl-auto=update


**Cómo levantar el microservicio
Usando Maven
# Construir el proyecto
mvn clean package

# Ejecutar
java -jar target/auth-service-0.0.1-SNAPSHOT.jar

Usando Docker
# Construir la imagen
docker build -t auth-service .

# Ejecutar el contenedor
docker run -p 8080:8080 --name auth-service auth-service

**Endpoints disponibles
Método	Endpoint	Descripción
POST	/auth/register	Registro de nuevo usuario
POST	/auth/login	Login de usuario
GET	/auth/users	Obtener todos los usuarios
GET	/auth/users/{id}	Obtener usuario por ID

**Validaciones de seguridad

Email único por usuario.

Contraseña debe tener:

Al menos 8 caracteres

Una letra mayúscula y una minúscula

Un número

Un símbolo especial (@$!%*?&)

Roles asignados automáticamente (USER por defecto).

**Estado del microservicio

✅ Registro y login de usuarios funcional

✅ Roles y control de acceso

⏳ Próximamente: integración con otros microservicios (Wallet, Transaction, Security)