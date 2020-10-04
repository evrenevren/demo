package com.demo.main.type.exception;

public class RequiredPremiumMembershipException extends Exception {

    public RequiredPremiumMembershipException() {
        super();
    }

    public RequiredPremiumMembershipException(String message) {
        super(message);
    }

    public RequiredPremiumMembershipException(String message, Throwable cause) {
        super(message, cause);
    }

}
