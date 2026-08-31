# FinVerse – Integrated Multi-Tenant Financial Services SaaS Platform

FinVerse is an institutional-grade, multi-tenant digital banking and financial services SaaS platform architected with **Java 21 / Spring Boot 3+** on the backend and **React 19 / TypeScript / Vite / Tailwind CSS** on the frontend.

## 1. Features Overview
- **Multi-Tenancy & RBAC**: Tenant context isolation (`X-Tenant-ID`), white-label customization, hierarchical corporate roles (`SUPER_ADMIN`, `TENANT_ADMIN`, `FINANCE_MANAGER`, `COMPLIANCE_OFFICER`, `CUSTOMER`).
- **Double-Entry General Ledger**: Mathematical ledger balancing, multi-legged journal entries, posting dates, trial balances, and three-way reconciliation.
- **Multi-Currency Accounts & Payments**: Checking, savings, treasury wallets, escrow vaults, Fedwire, SWIFT gpi, SEPA Instant, and ACH Nacha rails.
- **Commercial Invoicing & Subscriptions**: Itemized invoicing, tax engines, credit notes, SaaS plans, metered usage billing, and dunning workflows.
- **Lending & Expense Management**: Commercial loan underwriting, amortized repayment schedules, physical/virtual cards, and expense approval hierarchies.
- **KYC, AML & Fraud Engine**: Real-time velocity rules, geographic travel anomalies, synthetic identity checks, and FinCEN SAR filing dossiers.
- **Institutional Capital Markets & Treasury**: FX forwards, interest rate swaps, green bonds, trade finance letters of credit, and securities custody.

## 2. Prerequisites & Dependencies
- **Java 21 JDK** (Eclipse Temurin 21 recommended)
- **Maven 3.9+**
- **Node.js 20+** & **npm 10+**
- **Docker & Docker Compose**
- **PostgreSQL 16**, **Redis 7**, **Apache Kafka 7.5**

## 3. Installation
```bash
git clone https://github.com/GaddamVasavi/NeoBank-application.git finverse
cd finverse
make install
```

## 4. Build Instructions
```bash
# Build backend JAR and frontend production bundle
make build
```

## 5. Run Instructions
```bash
# Start all containerized microservices (Postgres, Redis, Kafka, Backend, Frontend)
docker compose up -d --build
```

## 6. Testing & Quality Assurance
```bash
make test
```

## 7. Security & Compliance
- Zero committed secrets (environment variable injected via `.env.example`).
- WORM storage immutable cryptographic SHA-256 HMAC audit logs.
- Multi-factor authentication (TOTP RFC 6238 / WebAuthn FIDO2) and TLS session encryption.
