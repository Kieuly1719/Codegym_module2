package ss2_VongLap;

import java.util.Scanner;

public class HienThi20SNT {
    public static void main(String args[]) {
        int i = 2;
        int dem = 0;
        while(true) {
            if(dem == 20){
                break;
            }
            if(checkSNT(i) == true){
                dem++;
                System.out.print(i + " ");
            }
            i++;
        }
    }
    public static boolean checkSNT(int num){
        int count = 0;
        for(int i = 2; i <= (int)Math.sqrt(num) + 1; i++){
            if(num % i == 0){
                count++;
            }
        }
        if(count == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
