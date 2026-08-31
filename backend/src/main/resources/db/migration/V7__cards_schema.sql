CREATE TABLE cards (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    account_id UUID NOT NULL REFERENCES accounts(id) ON DELETE CASCADE,
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    card_number VARCHAR(19) NOT NULL UNIQUE,
    cardholder_name VARCHAR(100) NOT NULL,
    card_type VARCHAR(20) NOT NULL,
    card_network VARCHAR(20) NOT NULL DEFAULT 'VISA',
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    expiry_month INT NOT NULL,
    expiry_year INT NOT NULL,
    cvv_hash VARCHAR(255) NOT NULL,
    pin_hash VARCHAR(255),
    daily_limit DECIMAL(15, 2) NOT NULL DEFAULT 2500.00,
    monthly_limit DECIMAL(15, 2) NOT NULL DEFAULT 15000.00,
    online_payments_enabled BOOLEAN NOT NULL DEFAULT TRUE,
    international_payments_enabled BOOLEAN NOT NULL DEFAULT FALSE,
    contactless_enabled BOOLEAN NOT NULL DEFAULT TRUE,
    atm_withdrawals_enabled BOOLEAN NOT NULL DEFAULT TRUE,
    is_virtual BOOLEAN NOT NULL DEFAULT FALSE,
    frozen_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    version BIGINT NOT NULL DEFAULT 0
);

CREATE INDEX idx_cards_user_id ON cards(user_id);
CREATE INDEX idx_cards_account_id ON cards(account_id);
CREATE INDEX idx_cards_number ON cards(card_number);
