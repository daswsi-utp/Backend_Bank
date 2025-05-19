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
