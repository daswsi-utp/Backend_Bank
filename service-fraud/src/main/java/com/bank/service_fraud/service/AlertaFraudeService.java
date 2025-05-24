package com.bank.service_fraud.service;

import java.util.List;
import com.bank.service_fraud.model.AlertaFraude;

public interface AlertaFraudeService {
	public List<AlertaFraude> listarSospechosas();
}
