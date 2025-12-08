package ss1_Introduce;

import java.util.Scanner;

public class AppDocSoThanhChu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số cần đọc: ");
        int number = input.nextInt();
        String kq = "";
        if (number >= 0 && number < 10) {
            System.out.println(readOneDigit(number));
        } else if (number >= 10 && number < 20) {
            int st2 = number % 10;
            kq = readOneDigit(st2) + "teen";
            System.out.println(kq);
        } else if (number >= 20 && number < 100) {
            int st2 = number % 10;
            int st1 = number / 10;
            System.out.println(readOneDigit(st1) + "ty " + readOneDigit(st2));
        } else {
            int st3 = number % 10;
            int st1 = number / 100;
            int st2 = (number - st1*100 - st3)/10;
            System.out.println(readOneDigit(st1) + " hundred " + readOneDigit(st2) + "ty " + readOneDigit(st3));
        }
    }
    public static String readOneDigit(int num) {
        switch (num) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "out of ability";
        }
    }
}
