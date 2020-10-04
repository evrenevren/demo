package com.demo.main.config;

import com.demo.main.type.dto.ResponseDto;
import com.demo.main.type.exception.PaymentServiceException;
import com.demo.main.type.exception.RequiredPremiumMembershipException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { RequiredPremiumMembershipException.class })
    protected ResponseEntity<Object> handleAllExceptions(RequiredPremiumMembershipException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.PAYMENT_REQUIRED;
        ResponseDto responseDto = new ResponseDto(ex.getMessage());
        return new ResponseEntity(responseDto, headers, status);
    }

    @ExceptionHandler(value = { PaymentServiceException.class })
    protected ResponseEntity<Object> handleAllExceptions(PaymentServiceException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.PAYMENT_REQUIRED;
        ResponseDto responseDto = new ResponseDto(ex.getMessage());
        return new ResponseEntity(responseDto, headers, status);
    }

}
