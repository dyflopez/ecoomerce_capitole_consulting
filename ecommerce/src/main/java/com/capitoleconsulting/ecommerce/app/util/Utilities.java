package com.capitoleconsulting.ecommerce.app.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {

    public static String LocalDateTimeToString(LocalDateTime date, String formatDate) {

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(formatDate);

        return date.format(formatoFecha);
    }

}
