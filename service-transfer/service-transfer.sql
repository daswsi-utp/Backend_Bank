-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS servicetransfer;

-- Use the created database
USE servicetransfer;

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
-- table: fees 
CREATE TABLE fees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id INT NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    FOREIGN KEY (transaction_id) REFERENCES transactions(id) ON DELETE CASCADE
);

-- table: transfer_limits
CREATE TABLE transfer_limits (
    account_id VARCHAR(50) PRIMARY KEY,
    daily_limit DECIMAL(12,2) NOT NULL
);
