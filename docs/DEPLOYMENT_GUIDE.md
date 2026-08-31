# NeoBank Production Deployment & Operations Guide

## 1. Running with Docker Compose
To start the entire banking platform locally with PostgreSQL, Spring Boot backend, and React frontend:
```bash
docker compose up -d --build
```
Access the application at `http://localhost` or `http://localhost:5173`.

## 2. Environment Variables
- `SPRING_DATASOURCE_URL`: PostgreSQL JDBC connection URL
- `SPRING_DATASOURCE_USERNAME`: Database user
- `SPRING_DATASOURCE_PASSWORD`: Database password
- `JWT_SECRET`: Base64-encoded 256-bit secret key
- `JWT_EXPIRATION_MS`: Access token lifespan (default 86400000 ms)
