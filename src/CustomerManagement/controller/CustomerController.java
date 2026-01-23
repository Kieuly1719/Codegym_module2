package CustomerManagement.controller;

import CustomerManagement.entity.Customer;
import CustomerManagement.service.CustomerService;
import CustomerManagement.service.ICustomerService;
import CustomerManagement.view.CustomerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerController
{
    private final ICustomerService customerService = new CustomerService();
    public CustomerController(){}
    public void displayMain(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("========Quản lý khach hàng========" +
                    "\n1. Danh sách khách hàng" +
                    "\n2. Thêm mới khách hàng" +
                    "\n3. Xoá khách hàng" +
                    "\n4. Cập nhật thông tin khach hàng" +
                    "\n5. Tìm kiếm gần đúng theo tên" +
                    "\n6. Thoát");
            System.out.println("Chọn chức năng:");
            int choose;
            try{
                choose = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e){
                choose = -1;
            }
            try{
                switch (choose) {
                    case 1:
                        List<Customer> customers = customerService.getListCustomer();
                        CustomerView.displayListCustomer(customers);
                        break;
                    case 2:
                        Customer newCustomer = CustomerView.addCustomerView();
                        customerService.addCustomer(newCustomer);
                        System.out.println("Thêm thành công!");
                        break;
                    case 3:
                        customers = customerService.getListCustomer();
                        CustomerView.displayListCustomer(customers);
                        String id = CustomerView.InputID();
                        Customer customerDel = customerService.getCustomerById(id);
                        customerService.deleteCustomer(customerDel);
                        System.out.println("Xóa thành công");
                        break;
                    case 4:
                        customers = customerService.getListCustomer();
                        CustomerView.displayListCustomer(customers);
                        Customer customer = CustomerView.updateCustomer();
                        customerService.updateCustomer(customer);
                        System.out.println("Cập nhật thành công");
                        break;
                    case 5:
                        String name = CustomerView.searchCustomerView();
                        List<Customer> results = customerService.searchCustomerByName(name);
                        CustomerView.displayListCustomer(results);
                        break;
                    case 6:
                        flag = false;
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại!");

                }
            } catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
            } catch(Exception e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
