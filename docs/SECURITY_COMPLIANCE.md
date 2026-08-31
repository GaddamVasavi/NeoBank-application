# NeoBank Security & Regulatory Compliance Guide

## 1. Authentication & Session Governance
- **Bcrypt 12 Rounds**: All customer passwords hashed with unique salts.
- **JWT Token Rotation**: Short-lived 15-minute access tokens with 7-day single-use refresh token rotation.
- **Device Fingerprinting**: Anomalous logins from unrecognized browsers require email/SMS OTP verification.

## 2. Financial Transaction Integrity
- **Idempotency Guarantee**: Requests carrying `X-Idempotency-Key` return identical cached responses on network timeout retries.
- **Optimistic Locking**: Account updates use Hibernate `@Version` to prevent race conditions during concurrent transfers.
- **Audit Trail**: Every financial movement, login attempt, and administrative action is logged to an immutable `audit_logs` table.

## 3. AML & Fraud Prevention
- Continuous risk scoring evaluating transaction volume, geographical anomalies, and account velocity.
- Automatic account freeze on critical AML rule violation.
