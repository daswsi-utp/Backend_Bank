CREATE DATABASE service_loan;
USE service_loan;


CREATE TABLE loan (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  client_id VARCHAR(100),
  amount DECIMAL(10,2),
  interest_rate DECIMAL(5,2),
  start_date DATE,
  term_in_months INT
);

INSERT INTO loan (client_id, amount, interest_rate, start_date, term_in_months) VALUES
('L001', 5000.00, 7.5, '2024-11-15', 24),
('L002', 12000.00, 6.0, '2024-12-01', 36),
('L003', 3000.00, 8.2, '2025-01-10', 12),
('L004', 7500.00, 5.5, '2025-02-01', 18),
('L005', 10000.00, 6.8, '2025-03-20', 30);

SELECT * FROM loan;