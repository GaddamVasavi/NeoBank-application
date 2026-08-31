# NeoBank REST API Catalog & Reference

All API endpoints require `Authorization: Bearer <token>` header, except public authentication routes.

## Authentication & Identity
- `POST /api/v1/auth/register` – Register customer account
- `POST /api/v1/auth/login` – Customer / Admin login
- `POST /api/v1/auth/verify-mfa` – Complete 2FA challenge
- `POST /api/v1/auth/refresh-token` – Rotate JWT refresh token
- `POST /api/v1/auth/logout` – Revoke active session tokens

## Accounts & Balances
- `GET /api/v1/accounts` – List all customer accounts
- `POST /api/v1/accounts` – Open new savings / checking account
- `GET /api/v1/accounts/{id}` – Account balance & metadata
- `PATCH /api/v1/accounts/{id}/limits` – Update daily & single transfer limits

## Transfers & Payments
- `POST /api/v1/transfers` – Execute internal / intra-bank money transfer
- `GET /api/v1/transfers/beneficiaries` – List saved beneficiaries
- `POST /api/v1/transfers/beneficiaries` – Add new transfer beneficiary
- `GET /api/v1/transactions/account/{id}` – Paginated transaction history

## Cards & Controls
- `GET /api/v1/cards` – List active debit/virtual cards
- `POST /api/v1/cards/issue` – Issue instant virtual/physical card
- `PATCH /api/v1/cards/{id}/freeze` – Toggle freeze card status
- `PUT /api/v1/cards/{id}/controls` – Update spending limits & online toggles

## Loans & Verification
- `GET /api/v1/loans/products` – List loan products & APRs
- `POST /api/v1/loans/apply` – Submit loan application & instant disbursement
- `POST /api/v1/kyc/upload` – Upload proof of identity / address
