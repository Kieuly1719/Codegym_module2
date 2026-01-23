package CustomerManagement.view;

import CustomerManagement.entity.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    public CustomerView() {}
    private static Scanner sc =  new Scanner(System.in);
    public static void displayListCustomer(List<Customer> customers) {
        System.out.println("--- Hiển thi danh sách ---");
        if(customers.isEmpty()) {
            System.out.println("Danh sách khách hàng trống!");
        }
        else{
            for(Customer cus : customers) {
                System.out.println(cus);
            }
        }
    }
    public static Customer addCustomerView(){
        System.out.println("--- THÊM KHÁCH HÀNG MỚI ---");
        System.out.println("Nhập ID: ");
        String id = sc.nextLine();
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập loại khách hàng (0. Cá nhân, 1. Doanh nghiệp): ");
        int type = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();
        return new Customer(id, name, type, address);

    }
    public static String InputID(){
        System.out.println("Nhập ID khách hàng: ");
        return sc.nextLine();
    }
    public static Customer updateCustomer(){
        System.out.println("\n--- Cập nhật thông tin ---");
        System.out.println("Nhập ID (Nhâp ID muốn sửa thông tin): ");
        String id = sc.nextLine();
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập loại khách hàng (0. Cá nhân, 1. Doanh nghiệp): ");
        int type = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();
        return new Customer(id, name, type, address);
    }
    public static String searchCustomerView(){
        System.out.println("Nhập tên bạn muốn tìm kiếm: ");
        return sc.nextLine();
    }
}
