# Multi-stage Root Container Entry Point for NeoBank Application
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY backend/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
