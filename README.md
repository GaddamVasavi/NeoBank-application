# NeoBank – Enterprise Digital Banking Platform

NeoBank is a high-throughput, secure, and production-grade full-stack digital banking simulator engineered with **Java 21 / Spring Boot 3** and **React 19 / TypeScript / Vite / Tailwind CSS**. The system simulates complete modern retail and commercial banking workflows with strict double-entry ledger consistency, multi-factor authentication, idempotency safeguards, real-time fraud & AML risk scoring, automated loan amortization engines, and comprehensive administrative oversight.

---

## Table of Contents
1. [Features Overview](#features-overview)
2. [Architecture & Technology Stack](#architecture--technology-stack)
3. [Prerequisites & Dependencies](#prerequisites--dependencies)
4. [Installation](#installation)
5. [Build Instructions](#build-instructions)
6. [Run Instructions](#run-instructions)
7. [API & Usage Documentation](#api--usage-documentation)
8. [Testing & Quality Assurance](#testing--quality-assurance)
9. [Security & Compliance](#security--compliance)

---

## Features Overview
- **Authentication & Security**: Multi-factor authentication (TOTP/SMS), JWT access & refresh token rotation, device fingerprinting, session governance, and password policy validation.
- **Account & Ledger Management**: Savings, Current/Checking, and Fixed Deposits with real-time balance recalculation, statements (PDF/CSV), and immutable audit trails.
- **Transfers & Bill Payments**: Internal own-account, intra-bank, and wire transfers with X-Idempotency-Key protection against duplicate executions, beneficiary address book, and utility bill payments.
- **Cards & Controls**: Virtual and physical Visa/Mastercard cards, dynamic lock/freeze toggles, spend velocity limiters, and hashed PIN security.
- **Loans & Credit**: Personal, Mortgage, and Auto loan products, continuous compound EMI amortization calculator, automatic schedule generation, and instant disbursement.
- **KYC & Verification**: Multi-stage document verification pipeline (Passport, Driver's License, National ID, Utility Bill) with automated compliance review queues.
- **AML & Fraud Detection Engine**: Rule-based anomaly detection, transaction velocity breach flags, and real-time risk scoring (0–100 scale).
- **Analytics & Admin Console**: Inflow/outflow cash-flow analytics, user governance (lock/suspend/activate), system configurations, and liquidity monitoring.

---

## Architecture & Technology Stack

### Backend
- **Language & Runtime**: Java 21 (Eclipse Temurin)
- **Framework**: Spring Boot 3.3.3
- **Security**: Spring Security 6, JJWT 0.12.6, BCrypt (12 rounds)
- **Persistence**: Spring Data JPA, Hibernate ORM, PostgreSQL 16
- **Database Migrations**: Flyway Database Migrations (V1 to V15)
- **Rate Limiting & Concurrency**: Bucket4j (Token Bucket algorithm)
- **Documentation**: Springdoc OpenAPI / Swagger UI 2.6.0

### Frontend
- **Framework**: React 19, TypeScript 5.5, Vite 5.4
- **Styling**: Tailwind CSS 3.4, PostCSS, Lucide Icons
- **State & Server Cache**: TanStack React Query 5, Context API
- **Forms & Validation**: React Hook Form 7, Zod 3.23
- **Charts & Visualizations**: Recharts 2.12
- **HTTP Client**: Axios 1.7 with token rotation interceptors

---

## Prerequisites & Dependencies
- **Docker & Docker Compose**: Docker 24.0+ and Docker Compose v2+
- **Java Development Kit**: JDK 21+ (for local backend compilation)
- **Apache Maven**: Maven 3.9+ (or use included mvnw)
- **Node.js & npm**: Node.js v20+ and npm 10+
- **PostgreSQL**: PostgreSQL 16 (if running without Docker)

---

## Installation

### 1. Clone the Repository
`ash
git clone https://github.com/your-org/neobank-application.git
cd neobank-application
`

### 2. Install Frontend Dependencies
`ash
cd frontend
npm install
cd ..
`

### 3. Install Backend Dependencies
`ash
cd backend
mvn clean install -DskipTests
cd ..
`

---

## Build Instructions

### Build Backend JAR
`ash
cd backend
mvn clean package -DskipTests
cd ..
`

### Build Frontend Production Assets
`ash
cd frontend
npm run build
cd ..
`

### Build Multi-Stage Docker Containers
`ash
docker compose build
`

---

## Run Instructions

### Option 1: Run Full Stack via Docker Compose (Recommended)
`ash
docker compose up -d
`
- **Web Application**: http://localhost (or http://localhost:5173)
- **REST API Gateway**: http://localhost:8080
- **Swagger Documentation**: http://localhost:8080/swagger-ui.html
- **PostgreSQL Database**: localhost:5432 (
eobank_db)

### Option 2: Run Locally for Development
1. Start PostgreSQL:
   `ash
   docker run --name neobank-postgres -e POSTGRES_DB=neobank_db -e POSTGRES_USER=neobank_user -e POSTGRES_PASSWORD=neobank_secure_password_2026 -p 5432:5432 -d postgres:16-alpine
   `
2. Start Backend:
   `ash
   cd backend
   mvn spring-boot:run
   `
3. Start Frontend:
   `ash
   cd frontend
   npm run dev
   `

---

## API & Usage Documentation

### Pre-seeded Demo Credentials
| Role | Username | Email | Password | Access Level |
|---|---|---|---|---|
| **Customer** | lex_hunter | lex.hunter@example.com | Password123! | Self-service banking, accounts, cards, transfers, loans |
| **Administrator** | dmin_sarah | sarah.admin@neobank.internal | AdminPassword123! | System oversight, user governance, AML fraud queue |

### Key API Endpoints
- POST /api/v1/auth/register – Create customer account
- POST /api/v1/auth/login – Authenticate customer/admin
- POST /api/v1/auth/verify-mfa – Validate 2FA TOTP code
- GET /api/v1/accounts – Fetch user accounts and balances
- POST /api/v1/transfers – Execute funds transfer with idempotency
- GET /api/v1/cards – List cards and toggle freeze/controls
- POST /api/v1/loans/apply – Submit loan application with EMI schedule
- POST /api/v1/kyc/upload – Upload identification documents
- GET /api/v1/admin/stats – Macro liquidity and system health metrics

---

## Testing & Quality Assurance

### Run Backend Unit & Integration Tests
`ash
cd backend
mvn clean test
`

### Run Frontend Component Tests
`ash
cd frontend
npm run test:run
`

---

## Security & Compliance
- **PCI-DSS Compliance**: No unhashed CVV or PIN values stored in plaintext.
- **GDPR / SOC2**: Audit logging of all access, profile edits, and balance modifications.
- **Rate Limiting**: Token-bucket algorithm enforcing 120 req/min general traffic and 15 req/min on auth endpoints.
- **Idempotency Safeguard**: Strict UUID tracking for financial transactions preventing double debits on network retry.
