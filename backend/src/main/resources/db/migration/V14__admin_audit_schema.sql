CREATE TABLE system_configs (
    id BIGSERIAL PRIMARY KEY,
    config_key VARCHAR(100) NOT NULL UNIQUE,
    config_value VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO system_configs (config_key, config_value, description) VALUES
('system.maintenance_mode', 'false', 'Global maintenance flag for user gateway'),
('limits.default_daily_transfer', '10000.00', 'Default daily transfer limit in USD'),
('fraud.auto_freeze_enabled', 'true', 'Enable automatic account freezing on high AML risk');
