CREATE TABLE transactions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    account_id UUID NOT NULL REFERENCES accounts(id) ON DELETE RESTRICT,
    reference_number VARCHAR(36) NOT NULL UNIQUE,
    transaction_type VARCHAR(30) NOT NULL,
    category VARCHAR(50) NOT NULL DEFAULT 'GENERAL',
    amount DECIMAL(15, 2) NOT NULL,
    fee DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    currency VARCHAR(10) NOT NULL DEFAULT 'USD',
    balance_after DECIMAL(15, 2) NOT NULL,
    description VARCHAR(255) NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'COMPLETED',
    counterparty_account VARCHAR(34),
    counterparty_name VARCHAR(100),
    counterparty_bank VARCHAR(100),
    transaction_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    version BIGINT NOT NULL DEFAULT 0
);

CREATE INDEX idx_transactions_account ON transactions(account_id);
CREATE INDEX idx_transactions_reference ON transactions(reference_number);
CREATE INDEX idx_transactions_date ON transactions(transaction_date DESC);
CREATE INDEX idx_transactions_category ON transactions(category);
