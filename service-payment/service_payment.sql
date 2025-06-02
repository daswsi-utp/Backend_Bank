
CREATE DATABASE service_payment;
USE service_payment;

CREATE TABLE payments (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  client_id VARCHAR(100),
  amount DECIMAL(10,2),
  payment_date DATE,
  method VARCHAR(50)
);


INSERT INTO payments (client_id, amount, payment_date, method) VALUES
('C001', 150.50, '2024-12-01', 'TRANSFERENCIA'),
('C002', 250.00, '2024-12-03', 'TARJETA'),
('C003', 90.75,  '2024-12-05', 'EFECTIVO'),
('C004', 310.20, '2024-12-07', 'TRANSFERENCIA'),
('C005', 70.00,  '2024-12-10', 'TARJETA');


SELECT * FROM payments;
