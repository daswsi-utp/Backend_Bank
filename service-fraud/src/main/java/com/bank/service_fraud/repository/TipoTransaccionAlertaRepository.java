package com.bank.service_fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.service_fraud.model.TipoTransaccionAlerta;

@Repository
public interface TipoTransaccionAlertaRepository extends JpaRepository<TipoTransaccionAlerta, Integer> {
}