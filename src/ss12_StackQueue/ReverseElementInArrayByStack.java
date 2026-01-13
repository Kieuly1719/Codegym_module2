package ss12_StackQueue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseElementInArrayByStack {
    public static void main(String[] args){
        System.out.print("Nhập số phần tử của mảng: ");
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            System.out.print("Nhập phần tử thứ " + (i+1) + " của mảng: ");
            Scanner sc = new Scanner(System.in);
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            stack.push(arr[i]);
        }
        StringBuilder kq = new StringBuilder();
        for(int i = 0; i < n; i++){
            arr[i]  = stack.pop();
            kq.append(arr[i]).append(" ");
        }
        System.out.println("Mảng sau khi đảo ngược là: " + kq);
    }
}
