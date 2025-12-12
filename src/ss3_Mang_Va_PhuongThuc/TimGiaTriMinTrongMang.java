package ss3_Mang_Va_PhuongThuc;

import java.util.Scanner;

public class TimGiaTriMinTrongMang {
    public static void main(String[] args){
        int[] arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            Scanner input = new Scanner(System.in);
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i] = input.nextInt();
        }
        int min = arr[0];
        for(int item: arr){
            if(item < min){
                min = item;
            }
        }
        System.out.println("Phần tử nhỏ nhất trong mảng là: " + min);
    }
}
