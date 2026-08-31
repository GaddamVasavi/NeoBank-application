# FinVerse REST API Reference & Endpoints

All REST APIs are versioned under `/api/v1/` and documentable via Swagger UI at `http://localhost:8080/swagger-ui.html`.
- `/api/v1/auth/*`: Authentication, MFA, passkeys, sessions.
- `/api/v1/tenants/*`: Tenant registration, white-labeling, settings.
- `/api/v1/accounts/*`: Multi-currency accounts, balances, statements.
- `/api/v1/ledger/*`: Journal vouchers, posting legs, trial balance.
- `/api/v1/payments/*`: Payment orchestration, capture, refunds.
- `/api/v1/transfers/*`: Domestic/international transfers, schedules.
- `/api/v1/invoices/*`: Itemized billing, tax calculation, PDF receipts.
- `/api/v1/subscriptions/*`: SaaS plans, usage metering, renewals.
- `/api/v1/loans/*`: Loan applications, underwriting, repayments.
- `/api/v1/cards/*`: Virtual/physical cards, controls, PINs.
- `/api/v1/kyc/*`: Identity verification, biometrics, sanctions screening.
- `/api/v1/fraud/*`: Velocity rules, alert cases, anomaly resolution.
