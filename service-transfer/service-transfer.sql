-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS service_transfer;

-- Use the created database
USE service_transfer;

-- Main table: transactions
CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    source_account_id VARCHAR(50) NOT NULL,
    destination_account_id VARCHAR(50) NOT NULL,
    amount DECIMAL(12, 2) NOT NULL,
    date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('pending', 'completed', 'failed') DEFAULT 'pending',
    reference VARCHAR(255)
);

-- Optional table: fees (if transfers have any fee logic)
CREATE TABLE fees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id INT NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    FOREIGN KEY (transaction_id) REFERENCES transactions(id) ON DELETE CASCADE
);

-- Optional table: daily transfer limits per account
CREATE TABLE transfer_limits (
    account_id VARCHAR(50) PRIMARY KEY,
    daily_limit DECIMAL(12,2) NOT NULL
);
