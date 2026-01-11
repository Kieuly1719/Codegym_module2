package ss10_DSA_DanhSach.Customer.Controller;

import ss10_DSA_DanhSach.Customer.Entity.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController {
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    public void displayList(){
        System.out.println("Danh sách khách hàng: ");
        for(int i = 0; i<customers.size(); i++){
            Customer cus = customers.get(i);
            System.out.print(cus.getName() + " | ");
            System.out.print(cus.getAddress() + " | ");
            System.out.println(cus.getType());
        }
    }
    public void addCustomer(Customer cus){
        customers.add(cus);
        System.out.println("Đã thêm thành công");
        displayList();
    }
    public void ReomveCus(String id){
        Customer cus = customers.get(Integer.parseInt(id) - 1);
        customers.remove(cus);
        System.out.println("Đã xóa thành công");
        displayList();
    }
    public void UpdateCus(String id){
        Customer cus = customers.get(Integer.parseInt(id) - 1);
        System.out.println("Cập nhật thông tin: ");
        System.out.println("Họ tên: ");
        Scanner sc = new Scanner(System.in);
        String newName = sc.nextLine();
        cus.setName(newName);
        System.out.println("Địa chỉ: ");
        String newAddress = sc.nextLine();
        cus.setAddress(newAddress);
        System.out.println("Cập nhật thành công");
        displayList();
    }
    public void findName(String name){
        for(int i = 0; i < customers.size(); i++){
            Customer cus = customers.get(i);
            if(cus.getName().contains(name)){
                System.out.println(cus.toString());
            }
        }
    }
}
