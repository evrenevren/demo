package com.demo.payment.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * Kredi karti bilgilerindeki son kullanim tarihinin suresini kontrol eder.
     * @param date son kullanim tarihi
     * @return son kullanim tarihinin suresi gecmis ise true sonucunu doner.
     */
    public static Date toDate(String date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date expiry = null;
        try {
            expiry = simpleDateFormat.parse(date);
        } catch (ParseException ignored) {

        }
        return expiry;
    }

}
