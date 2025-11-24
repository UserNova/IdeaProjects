# Image de base Java
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

# Répertoire de travail
WORKDIR /app

# Copier le JAR
COPY target/springdocker-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port
EXPOSE 8080

# Entrypoint simple, Spring Boot gère les retries de connexion à MySQL
ENTRYPOINT ["java", "-jar", "app.jar"]
