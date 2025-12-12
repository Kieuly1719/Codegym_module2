package ss3_Mang_Va_PhuongThuc;

public class Gop_Mang {
    public static void main(String[] args) {
        int[] Mang_T1 = {1,2,3,4,5};
        int[] Mang_T2 = {6,7,8,9,10,11};
        int[] Mang_T3 = new int[Mang_T1.length+Mang_T2.length];

        for(int i = 0; i < Mang_T1.length; i++){
            Mang_T3[i] = Mang_T1[i];
        }
        for(int i = 0; i < Mang_T2.length; i++){
            Mang_T3[i+Mang_T1.length] = Mang_T2[i];
        }
        for(int i = 0; i < Mang_T3.length; i++){
            System.out.print(Mang_T3[i] + " ");
        }
    }
}
