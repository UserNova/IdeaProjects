# Stage 1: build with Maven + JDK 21
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests -Dproject.build.sourceEncoding=UTF-8

# Stage 2: run the application
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENV JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
