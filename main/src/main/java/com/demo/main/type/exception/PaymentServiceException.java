package com.demo.main.type.exception;

public class PaymentServiceException extends Exception {

    public PaymentServiceException() {
        super();
    }

    public PaymentServiceException(String message) {
        super(message);
    }

    public PaymentServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
