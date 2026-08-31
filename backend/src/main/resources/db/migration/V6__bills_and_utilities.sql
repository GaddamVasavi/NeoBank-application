CREATE TABLE billers (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL UNIQUE,
    category VARCHAR(50) NOT NULL,
    account_identifier_name VARCHAR(60) NOT NULL DEFAULT 'Customer ID',
    logo_url VARCHAR(500),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE bill_payments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    account_id UUID NOT NULL REFERENCES accounts(id),
    biller_id UUID NOT NULL REFERENCES billers(id),
    reference_id VARCHAR(36) NOT NULL UNIQUE,
    consumer_number VARCHAR(60) NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    fee DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    currency VARCHAR(10) NOT NULL DEFAULT 'USD',
    status VARCHAR(30) NOT NULL DEFAULT 'COMPLETED',
    paid_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE recurring_bills (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    account_id UUID NOT NULL REFERENCES accounts(id),
    biller_id UUID NOT NULL REFERENCES billers(id),
    consumer_number VARCHAR(60) NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    frequency VARCHAR(30) NOT NULL DEFAULT 'MONTHLY',
    next_execution_date DATE NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO billers (name, category, account_identifier_name) VALUES
('City Power & Light', 'ELECTRICITY', 'Account Number'),
('Metro Water Authority', 'WATER', 'Consumer Number'),
('Clean Gas Energy', 'GAS', 'Meter Number'),
('HyperFiber Telecom', 'INTERNET', 'Subscriber ID'),
('National Health Care', 'INSURANCE', 'Policy Number');
