package ss14_SortAlgorithm;

import java.util.Arrays;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2,9,5,4,8,1};
        int[] arr1 = {2,9,5,4,8,1};
        int[] arr2 = {2,9,5,4,8,1};
        BubbleSort(arr);
        System.out.println();
        SelectionSort(arr1);
        System.out.println();
        InsertionSort(arr2);
    }
    public static void BubbleSort(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.print("Bubble Sort: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void SelectionSort(int[] arr){
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("Selection Sort: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void InsertionSort(int[] arr){
        int temp = 0;
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j >= 1; j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        System.out.print("Insertion Sort: " );
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
