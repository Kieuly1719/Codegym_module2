package ss12_StackQueue;

import java.util.Scanner;
import java.util.TreeMap;

public class CountWordOfString {
    public static void main(String[] args) {
        System.out.print("Nhập văn bản: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c,1);
            }
            else {
                int gtc = map.get(c);
                map.put(c,gtc+1);
            }
        }
        for(Character key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
