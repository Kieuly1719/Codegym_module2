package FuramaManagement.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String REGEX_ID_VILLA = "^SVVL-\\d{4}$";
    private static final String REGEX_ID_ROOM = "^SVRO-\\d{4}$";

    private static final String REGEX_NAME = "^[A-Z][a-z0-9]+(\\s[A-Z][a-z0-9]+)*$";

    public static void validateRegex(String value, String regex, String errorMsg) throws UserException{
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if(!matcher.matches()){
            throw new UserException(errorMsg);
        }
    }

    public static void validateArea(double area) throws UserException{
        if(area <= 30){
            throw new UserException("Lỗi: Diện tích phải lớn hơn 30 m2");
        }
    }

    public static void validateCost(double cost) throws UserException{
        if(cost <= 0){
            throw new UserException("Lỗi: Giá trị phải là số dương!");
        }
    }

    public static void validateMaxPeople(int people) throws UserException{
        if(people <= 0 || people >= 20){
            throw new UserException("Lôĩ: Số lợng người phải lớn hơn 0 và nhỏ hơn 20!");
        }
    }

    public static void validateFloors(int floors) throws UserException{
        if(floors <= 0){
            throw new UserException("Lỗi: Số tầng phải là số nguyên dương");
        }
    }

    public static void validateBirthday(String dateStr) throws UserException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            LocalDate birthDate = LocalDate.parse(dateStr, formatter);
            LocalDate now = LocalDate.now();
            int age = Period.between(birthDate, now).getYears();

            if(age < 18 || age > 100){
                throw new UserException("Lỗi: Tuổi phải từ 18 đến 100!");
            }
        }catch (DateTimeParseException e) {
            throw new UserException("Lỗi: Định dạng ngày tháng sai (dd/MM/yyyy) hoặc ngày không tồn tại!");
        }
    }

    public static String getRegexIdVilla() {
        return REGEX_ID_VILLA;
    }

    public static String getRegexIdRoom() { return REGEX_ID_ROOM; }
    public static String getRegexName() { return REGEX_NAME; }
}
