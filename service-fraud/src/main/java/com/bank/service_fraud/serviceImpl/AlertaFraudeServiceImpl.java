package com.bank.service_fraud.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.service_fraud.model.AlertaFraude;
import com.bank.service_fraud.repository.AlertaFraudeRepository;
import com.bank.service_fraud.service.AlertaFraudeService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AlertaFraudeServiceImpl implements AlertaFraudeService{
	
	private final AlertaFraudeRepository alertaRepository;
	
	@Override
	public List<AlertaFraude> listarSospechosas() {
		 return alertaRepository.findByScoreGreaterThan(80);
	}

}
