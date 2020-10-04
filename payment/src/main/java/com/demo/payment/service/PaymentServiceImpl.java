package com.demo.payment.service;

import com.demo.payment.type.dto.DebitCardDto;
import com.demo.payment.type.dto.ResponseDto;
import com.demo.payment.type.exception.CardFormatException;
import com.demo.payment.util.DebitCardUtils;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public ResponseDto checkout(DebitCardDto card) throws CardFormatException {
        DebitCardUtils.checkCardFormat(card);
        return new ResponseDto("İşlem başarıyla tamamlanmıştır.");
    }

}
