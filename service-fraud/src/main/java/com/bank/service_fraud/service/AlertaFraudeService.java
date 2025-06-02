package com.bank.service_fraud.service;

import java.util.List;
import com.bank.service_fraud.model.AlertaFraude;
import com.bank.service_fraud.response.GenericApiResponse;

public interface AlertaFraudeService {
	public List<AlertaFraude> listarSospechosas();
	public GenericApiResponse<AlertaFraude> actualizarConfirmacion(Integer idAlerta, Boolean confirmada) ;
	public List<AlertaFraude> listarTodas();
	public GenericApiResponse<AlertaFraude> crearAlerta(AlertaFraude alerta);
}
