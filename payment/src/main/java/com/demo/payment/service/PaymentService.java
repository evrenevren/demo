package com.demo.payment.service;

import com.demo.payment.type.dto.DebitCardDto;
import com.demo.payment.type.dto.ResponseDto;
import com.demo.payment.type.exception.CardFormatException;

public interface PaymentService {

    ResponseDto checkout(DebitCardDto card) throws CardFormatException;

}
