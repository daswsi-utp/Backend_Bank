package com.bank.service_fraud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service_fraud.model.AlertaFraude;
import com.bank.service_fraud.service.AlertaFraudeService;

@RestController
@RequestMapping("/api/alertas")
public class AlertaFraudeController {
	@Autowired
	private AlertaFraudeService alertaService;

	@GetMapping("/listarSospechosa")
	public ResponseEntity<?> listarSospechosas() {
		List<AlertaFraude> lista = alertaService.listarSospechosas();

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
}
