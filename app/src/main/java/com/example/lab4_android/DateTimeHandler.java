package com.example.lab4_android;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeHandler {

    private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss";

    public static String getDateFormat(Date dateTime) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(dateTime);
    }

    public static long localTimeToUtc(Date date) {
        String timeZone = Calendar.getInstance().getTimeZone().getID();
        Date utc = new Date(date.getTime() - TimeZone.getTimeZone(timeZone).getOffset(date.getTime()));
        long millisUtc = utc.getTime();
        return millisUtc;
    }

    public static String utcToLocalTime(long uctMillis) {
        Date utcDateTime = new Date(uctMillis);

        String timeZone = Calendar.getInstance().getTimeZone().getID();
        Date local = new Date(utcDateTime.getTime() + TimeZone.getTimeZone(timeZone).getOffset(utcDateTime.getTime()));

        String localTime = getDateFormat(local);
        return localTime;
    }
}
