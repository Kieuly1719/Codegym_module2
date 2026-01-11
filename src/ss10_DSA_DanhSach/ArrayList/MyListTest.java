package ss10_DSA_DanhSach.ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> List_ID = new MyList<>(5);
        List_ID.add(-1);
        List_ID.add(0);
        List_ID.add(3);
        List_ID.add(1);
        List_ID.add(5);
        System.out.println("Mảng ban đầu là: " + List_ID.toString());
        int m = List_ID.remove(0);
        System.out.println("Mảng Sau khi xóa -1 là: " + List_ID.toString());
        List_ID.add(7);
        System.out.println("Mảng sau khi thêm 7 là: " + List_ID.toString());
        List_ID.add(1,9);
        System.out.println("Mảng sau khi che 9 vào vị trí 1 là: " + List_ID.toString());
    }
}
