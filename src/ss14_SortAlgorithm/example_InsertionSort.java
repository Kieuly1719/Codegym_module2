package ss14_SortAlgorithm;

import java.util.Arrays;

public class example_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2,9,5,4,8,1};
        int temp = 0;
        for(int i=1;i<arr.length;i++){
            Array_Output(arr);
            System.out.println();
            System.out.println("Lần " + i + " ta chọn phần tử " + arr[i] + ": ");
            System.out.println("Tiến hành so sánh: ");
            for(int j = i; j >=1; j--){
                if (arr[j] < arr[j-1]){
                    System.out.println("- Phần tử " + arr[j] + " nhỏ hơn phần tử " + arr[j-1] + " nên ta tiến hành hoán đổi");
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    System.out.print("- Mảng sau khi hoán đôi là: ");
                    Array_Output(arr);
                    System.out.println();
                }
                else{
                    System.out.println("- Phần tử " + arr[j] + " lớn hơn phần tử " + arr[j-1] + " nên ta giữ nguyên");
                    break;
                }
            }
            System.out.print("Kết thúc buớc " + i + " ta có mảng: ");
            Array_Output(arr);
            System.out.println();
        }
    }
    public static void Array_Output(int[] arr){
        for(int j=0;j<arr.length;j++){
            System.out.print(arr[j] + " ");
        }
    }
}
