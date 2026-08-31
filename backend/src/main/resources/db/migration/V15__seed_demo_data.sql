-- NeoBank Seed Demo Data for Local Testing and Staging
DO $$
DECLARE
    cust_id UUID := gen_random_uuid();
    admin_id UUID := gen_random_uuid();
    sav_acc_id UUID := gen_random_uuid();
    chk_acc_id UUID := gen_random_uuid();
    role_cust_id BIGINT;
    role_adm_id BIGINT;
BEGIN
    SELECT id INTO role_cust_id FROM roles WHERE name = 'ROLE_CUSTOMER';
    SELECT id INTO role_adm_id FROM roles WHERE name = 'ROLE_ADMIN';

    -- Seed Demo Customer (Password: Password123!)
    INSERT INTO users (id, username, email, phone_number, password_hash, status, email_verified, phone_verified, mfa_enabled) VALUES
    (cust_id, 'alex_hunter', 'alex.hunter@example.com', '+1555019901', '$2a$12$Nq9v7.d6gG7K9v.q1v8gXeG1l6.vG7K9v.q1v8gXeG1l6.vG7K9v.', 'ACTIVE', true, true, false);

    INSERT INTO user_roles (user_id, role_id) VALUES (cust_id, role_cust_id);

    INSERT INTO customer_profiles (id, user_id, first_name, last_name, date_of_birth, gender, nationality, occupation, annual_income, kyc_status, risk_score) VALUES
    (gen_random_uuid(), cust_id, 'Alex', 'Hunter', '1992-05-14', 'MALE', 'US', 'Senior Software Engineer', 145000.00, 'VERIFIED', 5);

    INSERT INTO user_preferences (user_id, theme, currency, language) VALUES (cust_id, 'DARK', 'USD', 'en');

    INSERT INTO addresses (user_id, address_type, street_line1, city, state_province, postal_code, country, is_primary) VALUES
    (cust_id, 'RESIDENTIAL', '742 Evergreen Terrace', 'Springfield', 'OR', '97477', 'United States', true);

    -- Seed Demo Admin (Password: AdminPassword123!)
    INSERT INTO users (id, username, email, phone_number, password_hash, status, email_verified, mfa_enabled) VALUES
    (admin_id, 'admin_sarah', 'sarah.admin@neobank.internal', '+1555019999', '$2a$12$Nq9v7.d6gG7K9v.q1v8gXeG1l6.vG7K9v.q1v8gXeG1l6.vG7K9v.', 'ACTIVE', true, true);

    INSERT INTO user_roles (user_id, role_id) VALUES (admin_id, role_adm_id);

    -- Seed Accounts for Alex
    INSERT INTO accounts (id, user_id, account_number, account_type, status, currency, balance, available_balance, interest_rate, nickname) VALUES
    (sav_acc_id, cust_id, '400928174628', 'SAVINGS', 'ACTIVE', 'USD', 28450.75, 28450.75, 4.25, 'High-Yield Growth Reserve'),
    (chk_acc_id, cust_id, '400817293841', 'CHECKING', 'ACTIVE', 'USD', 4820.50, 4820.50, 0.00, 'Daily Operations Checking');

    -- Seed Transactions
    INSERT INTO transactions (account_id, reference_number, transaction_type, category, amount, balance_after, description, status, transaction_date) VALUES
    (chk_acc_id, 'TXN-90182-SALARY', 'DEPOSIT', 'INCOME', 5250.00, 7250.50, 'Employer Payroll Direct Deposit', 'COMPLETED', CURRENT_TIMESTAMP - INTERVAL '3 days'),
    (chk_acc_id, 'TXN-90183-GROCERY', 'CARD_PURCHASE', 'GROCERIES', -142.80, 7107.70, 'Whole Foods Market', 'COMPLETED', CURRENT_TIMESTAMP - INTERVAL '2 days'),
    (chk_acc_id, 'TXN-90184-UTIL', 'BILL_PAYMENT', 'ELECTRICITY', -95.20, 7012.50, 'City Power & Light Electric Bill', 'COMPLETED', CURRENT_TIMESTAMP - INTERVAL '1 day'),
    (sav_acc_id, 'TXN-90185-INT', 'INTEREST_CREDIT', 'INTEREST', 102.35, 28450.75, 'Monthly APY Interest Credit', 'COMPLETED', CURRENT_TIMESTAMP - INTERVAL '1 day');

    -- Seed Card
    INSERT INTO cards (account_id, user_id, card_number, cardholder_name, card_type, card_network, status, expiry_month, expiry_year, cvv_hash, is_virtual) VALUES
    (chk_acc_id, cust_id, '4532789012348821', 'ALEX HUNTER', 'DEBIT', 'VISA', 'ACTIVE', 11, 2029, '$2a$12$Nq9v7.d6gG7K9v.q1v8gXeG1l6.vG7K9v.q1v8gXeG1l6.vG7K9v.', false);

    -- Seed Notification
    INSERT INTO notifications (user_id, title, message, notificationType, is_read) VALUES
    (cust_id, 'Welcome to NeoBank', 'Your high-yield savings account is active and earning 4.25% APY.', 'SYSTEM', false),
    (cust_id, 'Direct Deposit Received', 'A direct deposit of $5,250.00 was posted to your checking account.', 'TRANSACTION', true);

END $$;
