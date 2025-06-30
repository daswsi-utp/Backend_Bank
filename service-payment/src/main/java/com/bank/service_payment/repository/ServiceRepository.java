package com.bank.service_payment.repository;

import com.bank.service_payment.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer> {
    boolean existsByCode(String code);
}
