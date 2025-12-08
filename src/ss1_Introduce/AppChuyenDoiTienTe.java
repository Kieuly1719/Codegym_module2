package ss1_Introduce;

import java.util.Scanner;

public class AppChuyenDoiTienTe {
    public static void main(String[] args) {
        int rate = 23000;
        System.out.print("Nhập giá tiền USD:");
        Scanner inputUSD = new Scanner(System.in);
        int USD = inputUSD.nextInt();
        double kq= USD*rate;
        System.out.println("Giá tiền Việt tương ứng: " + kq);
    }
}
