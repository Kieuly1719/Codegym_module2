package ss3_Mang_Va_PhuongThuc;

public class MangHaiChieu_TongDuongCheo {
    public static void main(String[] args) {
        int[][] arr = {
                {3,1,5},
                {2,7,0},
                {-1,6,-2}
        };
        if(arr.length != arr[0].length){
            System.out.println("Đây không phải ma trận đường chéo");
        }
        else{
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                sum += arr[i][i];
            }
            System.out.println("Tổng các phần tử ở đường chéo chính là: " + sum);
        }
    }
}
