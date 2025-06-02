package com.bank.service_fraud.response;

import java.time.LocalDateTime;

public class GenericApiResponse<T> {
	private int codigoRespuesta;
    private String message;
    private T data;
    private boolean status;
    private String timestamp;
    
    public GenericApiResponse() {
    	this.status = false;
    	this.timestamp = LocalDateTime.now().toString();
    }
  
    public GenericApiResponse(String message, T data, boolean status, int codigoRespuesta) {
        this.message = message;
        this.data = data;
        this.status = status;
        this.timestamp = LocalDateTime.now().toString();
        this.codigoRespuesta = codigoRespuesta;
    }
    
    public GenericApiResponse(String message, int codigoRespuesta, boolean status) {
        this.message = message;
        this.data = null;
        this.status = status;
        this.timestamp = LocalDateTime.now().toString();
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }
}
