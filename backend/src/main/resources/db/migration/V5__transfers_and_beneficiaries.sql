CREATE TABLE beneficiaries (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    name VARCHAR(100) NOT NULL,
    nickname VARCHAR(60),
    account_number VARCHAR(34) NOT NULL,
    bank_name VARCHAR(100) NOT NULL DEFAULT 'NeoBank',
    routing_number VARCHAR(30),
    swift_bic VARCHAR(20),
    email VARCHAR(120),
    phone_number VARCHAR(20),
    status VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
    is_internal BOOLEAN NOT NULL DEFAULT TRUE,
    is_favorite BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE transfers (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    source_account_id UUID NOT NULL REFERENCES accounts(id),
    destination_account_id UUID REFERENCES accounts(id),
    beneficiary_id UUID REFERENCES beneficiaries(id),
    reference_id VARCHAR(36) NOT NULL UNIQUE,
    idempotency_key VARCHAR(100) UNIQUE,
    transfer_type VARCHAR(30) NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    fee DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    currency VARCHAR(10) NOT NULL DEFAULT 'USD',
    status VARCHAR(30) NOT NULL DEFAULT 'PENDING',
    note VARCHAR(255),
    scheduled_date DATE,
    executed_at TIMESTAMP WITH TIME ZONE,
    failure_reason VARCHAR(255),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE idempotency_records (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    idempotency_key VARCHAR(100) NOT NULL UNIQUE,
    user_id UUID NOT NULL REFERENCES users(id),
    request_hash VARCHAR(128) NOT NULL,
    response_payload JSONB,
    status_code INT NOT NULL,
    expires_at TIMESTAMP WITH TIME ZONE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE INDEX idx_beneficiaries_user ON beneficiaries(user_id);
CREATE INDEX idx_transfers_source ON transfers(source_account_id);
CREATE INDEX idx_transfers_ref ON transfers(reference_id);
CREATE INDEX idx_idempotency_key ON idempotency_records(idempotency_key);
