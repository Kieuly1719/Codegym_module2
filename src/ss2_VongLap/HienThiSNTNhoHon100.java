package ss2_VongLap;

public class HienThiSNTNhoHon100 {
    public static void main(String[] args) {
        int i = 2;
        while(i<=100) {
            if(checkSNT(i) == true){
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
