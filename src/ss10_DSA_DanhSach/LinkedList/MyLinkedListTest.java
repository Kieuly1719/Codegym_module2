package ss10_DSA_DanhSach.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args){
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.add(-1);
        myList.add(0);
        myList.add(3);
        myList.add(1);
        myList.add(5);
        System.out.println("LinkedList ban đầu là: "+myList);
        myList.addFirst(7);
        System.out.println("LinkedList sau khi thêm 7 vào đầu là: "+myList);
        myList.addLast(8);
        System.out.println("LinkedList sau khi thêm 8 vào cuối là: "+myList);
        myList.add(3, 12);
        System.out.println("LinkedList sau khi thêm 12 vào sau vị trí là: "+myList);
        System.out.println("Phần tử ở vị trí 1 là: " + myList.get(1));
        System.out.println("Phần tử 1 ở vị trí là: " + myList.indexOf(1));
        System.out.println("Phần tử đầu có giá trị là: " + myList.getFirst());
        System.out.println("Phần tử cuối có giá trị là: " + myList.getLast());

    }
}
