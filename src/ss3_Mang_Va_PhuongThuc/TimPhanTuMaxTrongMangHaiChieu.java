package ss3_Mang_Va_PhuongThuc;

public class TimPhanTuMaxTrongMangHaiChieu {
    public static void main(String[] args) {
        int[][] arr = {
                {3,1,5},
                {2,7,0},
                {-1,6,-2}
        };
        int max = arr[0][0];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] > max){
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng 2 chiều là: " + max);
    }
}
