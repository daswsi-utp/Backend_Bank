package com.bank.service_fraud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.service_fraud.model.AlertaFraude;

@Repository
public interface AlertaFraudeRepository extends JpaRepository<AlertaFraude, Integer> {
	public List<AlertaFraude> findByScoreRiesgoGreaterThan(int score);
}