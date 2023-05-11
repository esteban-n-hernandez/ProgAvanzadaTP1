package ar.edu.usal.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String formatFecha() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy");
        return LocalDateTime.now().format(myFormatObj);
    }

}


