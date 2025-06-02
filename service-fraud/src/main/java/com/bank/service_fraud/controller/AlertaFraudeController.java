package com.bank.service_fraud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service_fraud.model.AlertaFraude;
import com.bank.service_fraud.response.GenericApiResponse;
import com.bank.service_fraud.service.AlertaFraudeService;

import jakarta.validation.Valid;

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

	@PatchMapping("/{id}/confirmacion")
	public ResponseEntity<GenericApiResponse<AlertaFraude>> actualizarConfirmacion(@PathVariable Integer id,
			@RequestParam Boolean confirmada) {

		GenericApiResponse<AlertaFraude> response = alertaService.actualizarConfirmacion(id, confirmada);
		return ResponseEntity.status(response.isStatus() ? 200 : 404).body(response);
	}

	@GetMapping("/listarTodas")
	public ResponseEntity<?> listarTodas() {
		List<AlertaFraude> lista = alertaService.listarTodas();

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<GenericApiResponse<AlertaFraude>> crearAlerta(@Valid @RequestBody AlertaFraude alerta) {
		GenericApiResponse<AlertaFraude> respuesta = alertaService.crearAlerta(alerta);
		return ResponseEntity.ok(respuesta);
	}
}
