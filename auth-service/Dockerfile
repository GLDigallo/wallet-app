# Imagen base
FROM openjdk:21-jdk-slim

# Directorio de la app
WORKDIR /app

# Copiar el jar generado por Maven
COPY target/auth-service-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
