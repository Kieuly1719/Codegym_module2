package ss13_SearchAlgorithm;

import java.util.Scanner;

public class AlgorithmComplexity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = sc.nextLine();
        int[] frequentChar = new int[255]; //1
        for(int i = 0; i < inputString.length(); i++) { //2
            int a = (int) inputString.charAt(i); //3
            frequentChar[a]++; //4
        }
        int max = 0; //5
        char character = (char) 255; //6
        for (int j = 0; j < 255; j++) { //7
            if (frequentChar[j] > max) { //8
                max = frequentChar[j]; //9
                character = (char) j; //10
            }
        }
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
}
/*Tính độ phức tạp:
    Thời gian thực hiện lệnh 1 là O(1)
    Thơ gian thực hiện lệnh 3 và 4 đều là O(1). Vòng lặp lệnh (2) thời gian thực thi là O(n)
    => O(n.1) = O(n)
    Tương tự, thời gian thực hiện lệnh 5 và 6 là O(1)
    Thời gian thực hiện lệnh 8 9 10 cũng là O(1)
    Thời gian thực hiện vòng lặp 7 là O(255) => O(255.1.1) = O(255)
    Độ phức tạp của thuật toán:
    - th1: n <= 255, độ phức tạp sẽ là lệnh 7 O(255)
    - th2: n > 255, độ phức tạp sẽ là lệnh 2 O(n)
*/
