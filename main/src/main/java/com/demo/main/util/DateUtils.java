package com.demo.main.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public static String toString(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Date addMonthToDate(Date input, int duration) {
        Calendar c = Calendar.getInstance();
        c.setTime(input);
        c.add(Calendar.MONTH, duration);
        return c.getTime();
    }

}
