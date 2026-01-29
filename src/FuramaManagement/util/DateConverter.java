package FuramaManagement.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate stringToDate(String date) {
        try{
            return LocalDate.parse(date, FORMATTER);
        }catch(Exception e){
            System.out.println("Lỗi định dạng ngày" + e.getMessage());
            return null;
        }
    }

    public static String dateToString(LocalDate date) {
        if(date == null){
            return null;
        }
        return date.format(FORMATTER);
    }
}
