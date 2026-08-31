CREATE TABLE monthly_snapshots (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    account_id UUID NOT NULL REFERENCES accounts(id) ON DELETE CASCADE,
    year INT NOT NULL,
    month INT NOT NULL,
    total_inflow DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    total_outflow DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    closing_balance DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    UNIQUE(account_id, year, month)
);
