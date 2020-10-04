package com.demo.payment.util;

import com.demo.payment.type.dto.DebitCardDto;
import com.demo.payment.type.exception.CardFormatException;
import org.springframework.util.StringUtils;

import java.util.Date;

public class DebitCardUtils {

    public static void checkCardFormat(DebitCardDto card) throws CardFormatException {
        if (card == null) {
            throw new CardFormatException("Kredi kartı olmadan işlem yapılamaz");
        }
        checkNameFormat(card);
        checkNoFormat(card);
        checkDateFormat(card);
        checkCvcFormat(card);
    }

    public static void checkNameFormat(DebitCardDto card) throws CardFormatException {
        if (StringUtils.isEmpty(card.getName())) {
            throw new CardFormatException("Kredi kartı bilgilerindeki ad-soyad alanı dolu olmalıdır");
        }
        if (!card.getName().matches("^[A-Za-z]+ [A-Za-z]+")) {
            throw new CardFormatException("Kredi kartı bilgilerindeki ad-soyad bir isim ve bir soyad içermelidir.");
        }
        if (card.getName().length() > 20) {
            throw new CardFormatException("Kredi kartı bilgilerindeki ad-soyad 20 karakterden fazla olamaz.");
        }
    }

    public static void checkNoFormat(DebitCardDto card) throws CardFormatException {
        if (StringUtils.isEmpty(card.getNo())) {
            throw new CardFormatException("Kredi kartı bilgilerindeki no alanı dolu olmalıdır");
        }
        String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
                "(?<mastercard>5[1-5][0-9]{14})|" +
                "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(?<amex>3[47][0-9]{13})|" +
                "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
                "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
        if (card.getNo().matches("regex")) {
            throw new CardFormatException("Kredi kartı bilgilerindeki kart numarası uygun formatta değildir.");
        }
        //Luhn Algorithm
        int sum = 0;
        boolean alternate = false;
        for (int i = card.getNo().length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(card.getNo().substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        if (sum % 10 != 0) {
            throw new CardFormatException("Kredi kartı bilgilerindeki kart numarası uygun formatta değildir.");
        }
    }

    public static void checkDateFormat(DebitCardDto card) throws CardFormatException {
        if (StringUtils.isEmpty(card.getExpiryDate())) {
            throw new CardFormatException("Kredi kartı bilgilerindeki son kullanma tarihi dolu olmalıdır");
        }
        if (!card.getExpiryDate().matches("(?:0[1-9]|1[0-2])/[0-9]{2}")) {
            throw new CardFormatException("Kredi kartı bilgilerindeki son kullanım tarihi uygun formatta değildir.(örnek: 08/24, 11/23)");
        }
        Date expiry = DateUtils.toDate(card.getExpiryDate(), "MM/yy");
        if (expiry != null && expiry.before(new Date())) {
            throw new CardFormatException("Kredi kartı bilgilerindeki son kullanım tarihinin süresi dolmuştur.");
        }
    }

    public static void checkCvcFormat(DebitCardDto card) throws CardFormatException {
        if (StringUtils.isEmpty(card.getCvc())) {
            throw new CardFormatException("Kredi kartı bilgilerindeki cvc alanı dolu olmalıdır");
        }
        if (!card.getCvc().matches("[0-9]{3}")) {
            throw new CardFormatException("Kredi kartı bilgilerindeki cvc numarası uygun değildir.(örnek: 123, 012)");
        }
    }

}
