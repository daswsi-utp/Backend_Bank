package com.bank.service_fraud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de excepciones de tipo MethodArgumentTypeMismatchException (cuando el parámetro no es válido)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
    		MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        String errorMessage = String.format("El parámetro '%s' no es válido. Se esperaba un valor de tipo '%s'.", 
                ex.getName(), ex.getRequiredType().getSimpleName());
        
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                errorMessage,
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                null,
                ex.getMessage() 
        );
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Manejo de excepciones de enlace de datos (Bad Request)
    @ExceptionHandler(org.springframework.validation.BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(BindingResult bindingResult, HttpServletRequest request) {
        List<String> errors = bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        /*
         String errorMessage;
        if (errors.size() == 1) {
            errorMessage = "El siguiente campo es obligatorio: " + errors.get(0);
        } else {
            errorMessage = "Los siguientes campos son obligatorios: " + String.join(", ", errors);
        } 
         */
        
        String errorMessage = "Por favor, corrige los errores en los campos obligatorios.";
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                errorMessage,
                request.getRequestURI(),
                bindingResult.getClass().getSimpleName(),
                errors,
                null
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Manejo de error cuando no se encuentra un recurso (404 Not Found)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex, 
    		HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage(),
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                null,
                ex.getMessage() 
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        Throwable rootCause = getRootCause(ex);
        
        // Mensaje del error original
        String originalMessage = ex.getMessage() != null ? ex.getMessage() : "Error interno del servidor";

        // Mensaje técnico (detalles de la excepción)
        String technicalMessage = rootCause != null ? rootCause.getMessage() : "Error interno del servidor";

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                originalMessage,  // Aquí usamos el mensaje original de la excepción
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                null,
                technicalMessage // Mensaje técnico con la causa raíz
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                "El recurso solicitado no existe.",
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                null,
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    private Throwable getRootCause(Throwable ex) {
        Throwable rootCause = ex;
        while (rootCause.getCause() != null && rootCause != rootCause.getCause()) {
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }
}
