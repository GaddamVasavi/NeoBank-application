CREATE TABLE IF NOT EXISTS kyc_records (
    id UUID PRIMARY KEY,
    tenant_id UUID NOT NULL REFERENCES tenants(id),
    user_id UUID NOT NULL REFERENCES users(id),
    verification_status VARCHAR(30) NOT NULL DEFAULT 'PENDING',
    risk_level VARCHAR(20) NOT NULL DEFAULT 'LOW',
    id_document_type VARCHAR(50),
    verified_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);
CREATE TABLE IF NOT EXISTS fraud_alerts (
    id UUID PRIMARY KEY,
    tenant_id UUID NOT NULL REFERENCES tenants(id),
    alert_reference VARCHAR(64) NOT NULL UNIQUE,
    rule_code VARCHAR(50) NOT NULL,
    severity VARCHAR(20) NOT NULL DEFAULT 'HIGH',
    risk_score INT NOT NULL DEFAULT 85,
    status VARCHAR(30) NOT NULL DEFAULT 'OPEN',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);
CREATE TABLE IF NOT EXISTS audit_logs (
    id UUID PRIMARY KEY,
    tenant_id UUID NOT NULL REFERENCES tenants(id),
    actor_email VARCHAR(100) NOT NULL,
    action VARCHAR(50) NOT NULL,
    entity_type VARCHAR(50) NOT NULL,
    entity_id VARCHAR(64) NOT NULL,
    ip_address VARCHAR(45),
    hash_seal VARCHAR(64) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);
CREATE INDEX idx_kyc_tenant ON kyc_records(tenant_id);
CREATE INDEX idx_fraud_tenant ON fraud_alerts(tenant_id);
CREATE INDEX idx_audit_tenant ON audit_logs(tenant_id);
