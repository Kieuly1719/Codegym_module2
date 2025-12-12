package ss3_Mang_Va_PhuongThuc;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args){
        String str = "Hello anh Hải và anh Trung";
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập ký tự cần tìm: ");
        char i = input.next().charAt(0);
        int count = 0;
        for(int j=0;j<str.length();j++){
            if(str.charAt(j)==i){
                count++;
            }
        }
        System.out.println("Số lần ký tự " + i + " xuất hiện trong chuỗi " + str + " là: " + count);
    }
}
