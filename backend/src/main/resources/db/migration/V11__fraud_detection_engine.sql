CREATE TABLE fraud_rules (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255),
    rule_type VARCHAR(40) NOT NULL,
    threshold_value DECIMAL(15, 2) NOT NULL,
    action VARCHAR(30) NOT NULL DEFAULT 'FLAG_REVIEW',
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE fraud_cases (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    transaction_id UUID REFERENCES transactions(id),
    case_reference VARCHAR(36) NOT NULL UNIQUE,
    risk_score INT NOT NULL,
    trigger_reason VARCHAR(255) NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'OPEN',
    assigned_to UUID REFERENCES users(id),
    resolution_notes TEXT,
    resolved_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO fraud_rules (name, description, rule_type, threshold_value, action) VALUES
('High Velocity Transfer', 'Triggered when transfer exceeds single threshold', 'HIGH_AMOUNT', 10000.00, 'FLAG_REVIEW'),
('Rapid Multiple Transactions', 'Detects multiple rapid transfers in under 60 seconds', 'VELOCITY', 5.00, 'FREEZE_ACCOUNT'),
('International Anomaly', 'Detects sudden international payment without prior history', 'GEO_ANOMALY', 1.00, 'FLAG_REVIEW');
