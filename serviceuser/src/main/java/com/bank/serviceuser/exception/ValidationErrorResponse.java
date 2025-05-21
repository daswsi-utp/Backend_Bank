/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.bank.serviceuser.exception;

import java.util.List;

public class ValidationErrorResponse {
    private String message;
    private List<FieldValidationError> errors;

    public ValidationErrorResponse(String message, List<FieldValidationError> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public List<FieldValidationError> getErrors() {
        return errors;
    }
}

