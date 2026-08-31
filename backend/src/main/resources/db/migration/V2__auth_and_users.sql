INSERT INTO roles (name, description) VALUES
('ROLE_CUSTOMER', 'Standard retail banking customer with access to self-service accounts and transfers'),
('ROLE_ADMIN', 'Super administrator with full system oversight, configuration and user governance'),
('ROLE_SUPPORT', 'Customer support specialist capable of viewing customer records and assisting tickets'),
('ROLE_COMPLIANCE_OFFICER', 'Risk and AML officer responsible for reviewing KYC documents and fraud alerts');

INSERT INTO permissions (name, description, category) VALUES
('AUTH_READ', 'Ability to view own authentication profile', 'AUTH'),
('ACCOUNT_READ', 'Ability to view account balances and details', 'ACCOUNT'),
('ACCOUNT_WRITE', 'Ability to open or modify accounts', 'ACCOUNT'),
('TRANSFER_EXECUTE', 'Ability to execute financial transfers', 'PAYMENT'),
('BILL_PAY', 'Ability to pay utility bills', 'PAYMENT'),
('CARD_MANAGE', 'Ability to manage payment cards', 'CARD'),
('LOAN_APPLY', 'Ability to submit loan applications', 'LOAN'),
('ADMIN_USERS_MANAGE', 'Ability to view and edit user statuses', 'ADMIN'),
('ADMIN_FRAUD_MANAGE', 'Ability to investigate and resolve fraud cases', 'ADMIN'),
('ADMIN_KYC_VERIFY', 'Ability to approve or reject KYC documents', 'COMPLIANCE'),
('AUDIT_READ', 'Ability to query immutable system audit logs', 'AUDIT');

INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id FROM roles r, permissions p
WHERE r.name = 'ROLE_CUSTOMER' AND p.name IN ('AUTH_READ', 'ACCOUNT_READ', 'ACCOUNT_WRITE', 'TRANSFER_EXECUTE', 'BILL_PAY', 'CARD_MANAGE', 'LOAN_APPLY');

INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id FROM roles r, permissions p
WHERE r.name = 'ROLE_SUPPORT' AND p.name IN ('AUTH_READ', 'ACCOUNT_READ', 'AUDIT_READ');

INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id FROM roles r, permissions p
WHERE r.name = 'ROLE_COMPLIANCE_OFFICER' AND p.name IN ('AUTH_READ', 'ACCOUNT_READ', 'ADMIN_FRAUD_MANAGE', 'ADMIN_KYC_VERIFY', 'AUDIT_READ');

INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id FROM roles r, permissions p
WHERE r.name = 'ROLE_ADMIN';
