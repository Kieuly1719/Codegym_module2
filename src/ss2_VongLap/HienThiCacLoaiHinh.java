package ss2_VongLap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        System.out.println("Menu:");
        System.out.println("    1. Print the rectangle");
        System.out.println("    2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
        System.out.println("    3. Print isosceles triangle");
        System.out.println("    4. Exit");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your choose: ");
        int choice = input.nextInt();
        if(choice == 1){
            String ch = "* * * * * * *";
            for(int i = 0; i < 3; i++){
                System.out.println(ch);
            }
        }
        else if(choice == 2){
            for(int i = 1; i <= 5; i++){
                for(int j = 1; j <= i; j++){
                    System.out.print("* ");
                }
                System.out.println();
            }
        } else if(choice == 3){
            for(int i = 5; i >= 1; i--){
                for(int j = 1; j <= i; j++){
                    System.out.print("* ");

                }
                System.out.println();
            }
        }
        else if(choice == 4){
            System.out.println("Bạn đã thoát menu");
        }
        else{
            System.out.println("Lựa chọn không hợp lệ");
        }
    }
}
