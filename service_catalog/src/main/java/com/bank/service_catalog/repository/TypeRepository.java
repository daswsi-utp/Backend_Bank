package com.bank.service_catalog.repository;

import com.bank.service_catalog.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Byte> {
    boolean existsByModuleAndName(String module, String name);
}
