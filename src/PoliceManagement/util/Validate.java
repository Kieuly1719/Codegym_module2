package PoliceManagement.util;

import PoliceManagement.repository.IVehicleRepository;
import PoliceManagement.repository.VehicleRepository;
import PoliceManagement.service.IVehicleService;
import PoliceManagement.service.VehicleService;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    private final IVehicleService vehicleService = new VehicleService();
    private static final String REGEX_TRUCK = "^[0-9]{2}C-[0-9]{3}\\.[0-9]{2}$";
    private static final String REGEX_CAR = "^[0-9]{2}[AB]-[0-9]{3}\\.[0-9]{2}$";
    private static final String REGEX_MOTOR = "^[0-9]{2}-[A-Z]{2}1-[0-9]{3}\\.[0-9]{2}$";

    public static String inputAndValidatePlate(Scanner scanner, int type){
        String regex = "";
        String example = "";
        String bks;
        switch (type){
            case 0:
                regex = REGEX_TRUCK;
                example = "XXC-XXX.XX (VD: 29C-123.45)";
                break;
            case 1:
                regex = REGEX_CAR;
                example = "XXY-XXX.XX (Y=A,B - VD: 30A-123.45)";
                break;
            case 2:
                regex = REGEX_MOTOR;
                example = "XX-YZ-XXX.XX (VD: 29-H1-123.45)";
                break;
        }
        while(true){
            bks = scanner.nextLine();
            if(bks.isEmpty()){
                System.err.println("Lỗi: Biển kiểm soát không được để trống!");
                continue;
            }
            if(!Pattern.matches(regex, bks)){
                System.err.println("Lỗi: Định dạng biển kiểm soát không đúng " + regex + "!");
                continue;
            }
            return bks;
        }
    }
    public static String inputString(Scanner scanner, String fieldName){
        String input;
        while(true){
            System.out.println("Nhập " + fieldName + ":");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Lỗi: " + fieldName + " không được để trống!");
            } else {
                return input;
            }
        }
    }
    public static double inputDouble(Scanner scanner, String fieldName){
        while (true) {
            try {
                System.out.print("Nhập " + fieldName + ": ");
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value <= 0) {
                    System.err.println("Lỗi: " + fieldName + " phải lớn hơn 0!");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập số hợp lệ!");
            }
        }
    }
    public static int inputInt(Scanner scanner, String fieldName){
        while (true) {
            try {
                System.out.print("Nhập " + fieldName + ": ");
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value <= 0) {
                    System.err.println("Lỗi: " + fieldName + " phải lớn hơn 0!");
                } else {
                    return value;
                }
            }  catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập số hợp lệ!");
            }
        }
    }
}
