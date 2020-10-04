package com.demo.payment.type.exception;

public class CardFormatException extends Exception {

    public CardFormatException() {
        super();
    }

    public CardFormatException(String message) {
        super(message);
    }

    public CardFormatException(String message, Throwable cause) {
        super(message, cause);
    }

}
