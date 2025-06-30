package com.bank.service_catalog.repository;

import com.bank.service_catalog.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Byte> {
    boolean existsByModuleAndName(String module, String name);
}
