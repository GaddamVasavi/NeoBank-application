# FinVerse Database Schema & Migration Guide

The platform uses PostgreSQL 16 managed via Flyway versioned migrations:
- `V1__init_tenants_users.sql`: Tenant profiles, settings, users, roles, permissions.
- `V2__init_accounts_ledger.sql`: Accounts, ledger chart, journal entries, debit/credit legs.
- `V3__init_commerce_lending_cards.sql`: Invoices, subscriptions, loans, cards, expenses.
- `V4__init_risk_compliance_analytics.sql`: KYC dossiers, AML cases, fraud alerts, immutable audit blocks.
