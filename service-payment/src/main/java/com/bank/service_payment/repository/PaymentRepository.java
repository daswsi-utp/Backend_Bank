package com.bank.service_payment.repository;


import com.bank.service_payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;   

public interface PaymentRepository extends JpaRepository<Payment, Long>{
    
}