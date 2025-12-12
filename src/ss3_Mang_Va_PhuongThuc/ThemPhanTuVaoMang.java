package ss3_Mang_Va_PhuongThuc;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[] Mang_num = {10,4,6,7,8,0,0,0,0,0};
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số cần chèn: ");
        int sct = sc.nextInt();
        Scanner index = new Scanner(System.in);
        System.out.print("Nhập vị trí cần chèn: ");
        int index_sct = index.nextInt();

        if(index_sct <= -1 || index_sct >= Mang_num.length){
            System.out.println("Vị trí cần chèn X không hợp lệ");
        }
        else{
            int n = Mang_num.length;
            int[] Mang_KQ = new int[n];
            for(int i = 0; i < n; i++){
                if(i < index_sct){
                    Mang_KQ[i] = Mang_num[i];
                }
                else{
                    if(i == index_sct){
                        Mang_KQ[i] = sct;
                    }
                    else{
                        Mang_KQ[i] = Mang_num[i-1];
                    }
                }
            }
            for(int i = 0; i < Mang_KQ.length; i++){
                System.out.print(Mang_KQ[i] + " ");
            }
        }
    }
}
