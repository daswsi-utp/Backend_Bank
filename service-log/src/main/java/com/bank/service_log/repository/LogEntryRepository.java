package com.bank.service_log.repository;

import com.bank.service_log.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {
    List<LogEntry> findByUserId(Long userId);
}
