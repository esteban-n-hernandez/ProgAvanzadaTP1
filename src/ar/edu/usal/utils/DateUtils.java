package ar.edu.usal.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    /*
    Formatear fecha con el pattern de ddMMyyyy que se usa para el nombre del archivo
     */
    public static String formatFecha() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy");
        return LocalDateTime.now().format(myFormatObj);
    }

}


