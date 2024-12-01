package com.hexaware.easyspay.exceptions;

public class PayrollNotFoundException extends RuntimeException {
    public PayrollNotFoundException(String message) {
        super(message);
    }
}
