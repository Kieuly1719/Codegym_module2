package ss10_DSA_DanhSach.Customer;

import ss10_DSA_DanhSach.Customer.Controller.CustomerController;
import ss10_DSA_DanhSach.Customer.Entity.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Trần Thị Kiều Ly", "Quảng Nam", 1);
        Customer customer2 = new Customer("Huỳnh Văn Quyền", "Đà Nẵng", 1);
        CustomerController customerController = new CustomerController();
        customerController.addCustomer(customer1);
        customerController.addCustomer(customer2);
        customerController.ReomveCus("1");
    }
}
