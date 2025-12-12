package ss3_Mang_Va_PhuongThuc;

import java.util.Scanner;

public class TinhTongCacSoInMotCot {
    public static void main(String[] args) {
        int[][] arr = {
                {3,1,5},
                {2,7,0},
                {-1,6,-2}
        };
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập cột muốn tính tổng (0 - " + (arr.length-1)  + ") :");
        int n = input.nextInt();
        int sum = 0;
        if(n < 0 || n > arr.length){
            System.out.println("Cột nhập không hợp lệ");
        }
        else{
            for(int i = 0; i < arr.length; i++){
                sum += arr[i][n];
            }
            System.out.println("Tổng của cột " + n +" là: " + sum);
        }
    }
}
