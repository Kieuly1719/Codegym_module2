package ss13_SearchAlgorithm;

import java.rmi.dgc.VMID;

public class ImplementBST_Recursion {
    public static void main(String[] args) {
        int[] arr = {1,4,5,7,8,11,26};
        binarySearch(arr, 11);
        System.out.println("Kết quả bằng đệ quy: " + binarySearch_Recursion(arr, 0, arr.length, 11));
    }
    public static void binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(arr[mid] < value){
                left = mid + 1;
            }
            else if(arr[mid] > value){
                right = mid - 1;
            }
            else{
                break;
            }
        }
        System.out.println("Kết quả tìm kiếm phần tử " + value + " là: " + mid + " trong mảng arr");
    }
    public static int binarySearch_Recursion(int[] arr, int left, int right, int value){
        int mid = left + (right - left) / 2;
        if(arr[mid] == value){
            return mid;
        }
        if(arr[mid] < value){
            return binarySearch_Recursion(arr, mid+1, right, value);
        }
        else{
            return binarySearch_Recursion(arr, left, mid-1, value);
        }
    }
}
