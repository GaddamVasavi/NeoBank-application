CREATE TABLE IF NOT EXISTS invoices (
    id UUID PRIMARY KEY,
    tenant_id UUID NOT NULL REFERENCES tenants(id),
    invoice_number VARCHAR(64) NOT NULL UNIQUE,
    customer_name VARCHAR(100) NOT NULL,
    subtotal NUMERIC(18, 4) NOT NULL DEFAULT 0.0000,
    tax_amount NUMERIC(18, 4) NOT NULL DEFAULT 0.0000,
    total_amount NUMERIC(18, 4) NOT NULL DEFAULT 0.0000,
    status VARCHAR(30) NOT NULL DEFAULT 'DRAFT',
    due_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW() + INTERVAL '30 days',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);
CREATE TABLE IF NOT EXISTS loans (
    id UUID PRIMARY KEY,
    tenant_id UUID NOT NULL REFERENCES tenants(id),
    loan_reference VARCHAR(64) NOT NULL UNIQUE,
    borrower_name VARCHAR(100) NOT NULL,
    principal_amount NUMERIC(18, 4) NOT NULL DEFAULT 0.0000,
    interest_rate NUMERIC(6, 4) NOT NULL DEFAULT 0.0500,
    term_months INT NOT NULL DEFAULT 36,
    status VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);
CREATE TABLE IF NOT EXISTS cards (
    id UUID PRIMARY KEY,
    tenant_id UUID NOT NULL REFERENCES tenants(id),
    card_token VARCHAR(64) NOT NULL UNIQUE,
    masked_pan VARCHAR(20) NOT NULL,
    cardholder_name VARCHAR(100) NOT NULL,
    card_type VARCHAR(20) NOT NULL DEFAULT 'VIRTUAL',
    spend_limit NUMERIC(18, 4) NOT NULL DEFAULT 5000.0000,
    status VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);
CREATE INDEX idx_invoices_tenant ON invoices(tenant_id);
CREATE INDEX idx_loans_tenant ON loans(tenant_id);
CREATE INDEX idx_cards_tenant ON cards(tenant_id);
