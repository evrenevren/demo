package com.demo.payment.config;

import com.demo.payment.type.dto.ResponseDto;
import com.demo.payment.type.exception.CardFormatException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { CardFormatException.class })
    protected ResponseEntity handleAllExceptions(CardFormatException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;
        ResponseDto responseDto = new ResponseDto(ex.getMessage());
        return new ResponseEntity(responseDto, headers, status);
    }

}
