package com.githubtools.demo.helper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeHelper {


    private DateTimeHelper(){ super();}

    public static String dateToISO8601Format(Date dateTime){
        String isoDatePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        String dateString = simpleDateFormat.format(dateTime);
        return dateString;
    }

    public static LocalDate stringToLocalDateTime(String dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateTime, formatter);
        return localDate;
    }
}
