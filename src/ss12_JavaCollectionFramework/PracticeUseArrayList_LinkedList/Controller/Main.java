package ss12_JavaCollectionFramework.PracticeUseArrayList_LinkedList.Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        while(true){
            System.out.println("Quản lý sản phẩm: ");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo id");
            System.out.println("3. Xóa sản phẩm theo id");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm theo giá");
            System.out.println("7. Exit");
            System.out.print("Nhập lựa chọn của bạn: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if(choice == 1){
                productManager.addProduct();
            }
            else if(choice == 2){
                productManager.UpdateProductById();
            }
            else if(choice == 3){
                productManager.removeProduct();
            }
            else if(choice == 4){
                productManager.DisplayAllProducts();
            }
            else if(choice == 5){
                productManager.FindProductByName();
            }
            else if(choice == 6){
                productManager.SortByPrice();
            }
            else if(choice == 7){
                System.exit(0);
            }
            else{
                System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại");
            }
        }
    }
}
