package com.bank.service_fraud.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bank.service_fraud.model.AlertaFraude;
import com.bank.service_fraud.repository.AlertaFraudeRepository;
import com.bank.service_fraud.response.GenericApiResponse;
import com.bank.service_fraud.service.AlertaFraudeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlertaFraudeServiceImpl implements AlertaFraudeService {

	private final AlertaFraudeRepository alertaRepository;

	@Override
	public List<AlertaFraude> listarSospechosas() {
		return alertaRepository.findByScoreRiesgoGreaterThan(80);
	}

	@Override
	public GenericApiResponse<AlertaFraude> actualizarConfirmacion(Integer idAlerta, Boolean confirmada) {
		Optional<AlertaFraude> alertaOpt = alertaRepository.findById(idAlerta);
		if (alertaOpt.isPresent()) {
			AlertaFraude alerta = alertaOpt.get();
			alerta.setConfirmada(confirmada);
			alertaRepository.save(alerta);
			return new GenericApiResponse<>("Alerta actualizada correctamente", alerta, true, 0);
		} else {
			return new GenericApiResponse<>("Alerta no encontrada", null, false, 1);
		}
	}

}
