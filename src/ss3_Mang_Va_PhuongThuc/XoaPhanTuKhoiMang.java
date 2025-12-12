package ss3_Mang_Va_PhuongThuc;

import java.sql.SQLOutput;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args){
        int[] MyList = {10,4,6,7,8,6,0,0,0};

        Scanner inputRemove = new Scanner(System.in);
        System.out.print("Nhập số cần xóa: ");
        int rv = inputRemove.nextInt();
        int index_rv = 0;
        for(int i = 0; i < MyList.length; i++){
            if(MyList[i] == rv){
                index_rv = i;
            }
        }
        for (int i = index_rv; i < MyList.length; i++){
            if(i != MyList.length - 1){
                MyList[i] = MyList[i+1];
            }
            else{
                MyList[i] = 0;
            }
        }
        for(int item: MyList){
            System.out.print(item + " ");
        }
    }
}
