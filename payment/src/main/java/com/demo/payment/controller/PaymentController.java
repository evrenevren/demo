package com.demo.payment.controller;

import com.demo.payment.service.PaymentService;
import com.demo.payment.type.constant.RequestMappingConstant;
import com.demo.payment.type.dto.DebitCardDto;
import com.demo.payment.type.dto.ResponseDto;
import com.demo.payment.type.exception.CardFormatException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestMappingConstant.PAYMENT)
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = RequestMappingConstant.CHECK_OUT)
    public ResponseDto checkout(@RequestBody DebitCardDto debitCard) throws CardFormatException {
        return paymentService.checkout(debitCard);
    }

}
