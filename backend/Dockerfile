# Multi-stage Production Dockerfile for NeoBank Java 21 Spring Boot Backend
FROM maven:3.9.8-eclipse-temurin-21-alpine AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests --batch-mode

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
RUN addgroup -S neobank && adduser -S neobank -G neobank
COPY --from=builder /build/target/*.jar app.jar
USER neobank
EXPOSE 8080
ENTRYPOINT ["java", "-XX:+UseG1GC", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
