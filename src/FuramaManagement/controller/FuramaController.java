package FuramaManagement.controller;

import FuramaManagement.entity.Booking;
import FuramaManagement.entity.Customer;
import FuramaManagement.entity.Employee;
import FuramaManagement.entity.Facility;
import FuramaManagement.service.*;
import FuramaManagement.view.FuramaView;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FuramaController {
    Scanner sc = new Scanner(System.in);
    private final FuramaView furamaView = new FuramaView();
    private final IEmployeeService employeeService = new EmployeeService();
    private final IBookingService bookingService = new BookingService();
    private final ICustomerService customerService = new CustomerService();
    private final IFacilityService facilityService = new FacilityService();
    private final IPromotionService  promotionService = new PromotionService();

    public void displayMain(){
        boolean flag = true;
        while (flag) {
            System.out.println("Menu: " +
                    "\n1. Employee Management" +
                    "\n2. Customer Management" +
                    "\n3. Facility Management" +
                    "\n4. Booking Management" +
                    "\n5. Promotion Managemt" +
                    "\n6. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayEmployeeMenu();
                    break;
                case 2:
                    displayCustomerMenu();
                    break;
                case 3:
                    displayFacilityMenu();
                    break;
                case 4:
                    displayBookingMenu();
                    break;
                case 5:
                    displayPromotionMenu();
                    break;
                default:
                    flag = false;
            }
        }
    }
    public void displayEmployeeMenu(){
        boolean flag = true;
        boolean kq;
        String id;
        Employee employee;
        List<Employee> employees;
        while (flag) {
            System.out.println("\nEmployee Management: " +
                    "\n1. Display list employees" +
                    "\n2. Add new employee" +
                    "\n3. Delete employee" +
                    "\n4. Edit employee" +
                    "\n5. Return main menu");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    employees = employeeService.findAll();
                    furamaView.displayList(employees);
                    break;
                case 2:
                    employee = furamaView.addEmployeeView();
                    kq = employeeService.add(employee);
                    if(!kq){
                        System.out.println("Employee ID already exits");
                    }
                    else{
                        System.out.println("Add Employee success!");
                    }
                    break;
                case 3:
                    id = furamaView.InputID();
                    kq = employeeService.delete(id);
                    if(!kq){
                        System.out.println("Employee ID does not exits");
                    }
                    else{
                        System.out.println("Delete Employee success!");
                    }
                    break;
                case 4:
                    id = furamaView.InputID();
                    employee = employeeService.findEmployeeByID(id);
                    if(employee == null){
                        System.out.println("Employee ID does not exits");
                    }
                    else {
                        employee = furamaView.addEmployeeView();
                        kq = employeeService.update(employee);
                        if (!kq) {
                            System.out.println("Employee ID does not exits");
                        } else {
                            System.out.println("Edit Employee success!");
                        }
                    }
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    public void displayCustomerMenu(){
        boolean flag = true;
        boolean kq;
        List<Customer> customers;
        Customer customer;
        while (flag) {
            System.out.println("\nCustomer Management: " +
                    "\n1. Display list customers" +
                    "\n2. Add new customer" +
                    "\n3. Edit customer" +
                    "\n4. Return main menu");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    customers = customerService.findAll();
                    furamaView.displayList(customers);
                    break;
                case 2:
                    System.out.println("Add new customer: ");
                    customer = furamaView.addCustomerView();
                    kq = customerService.add(customer);
                    if(!kq){
                        System.out.println("Customer ID already exits");
                    }
                    else{
                        System.out.println("Add Customer success!");
                    }
                    break;
                case 3:
                    String id = sc.nextLine();
                    customer = customerService.findByCustomer_ID(id);
                    if(customer == null){
                        System.out.println("Customer ID does not exits");
                    }
                    else {
                        System.out.println("Edit customer: ");
                        customer = furamaView.addCustomerView();
                        kq = customerService.update(customer);
                        if(!kq){
                            System.out.println("Customer ID does not exits");
                        }
                        else{
                            System.out.println("Edit Customer success!");
                        }
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }
    public void displayFacilityMenu(){
        boolean flag = true;
        Map<Facility, Integer> facilities;
        while(flag) {
            System.out.println("\nFacility Management: " +
                    "\n1. Display list facility" +
                    "\n2. Add new facility" +
                    "\n3. Display list facility maintenance" +
                    "\n4. Return main menu");
            System.out.println("Enter your choice: ");
            int choice = furamaView.InputInt();
            switch (choice) {
                case 1:
                    facilities = facilityService.findAllMap();
                    furamaView.displayListFacility(facilities);
                    break;
                case 2:
                    System.out.println("Add new facility: ");
                    ViewAddFacilityMenu();
                    break;
                case 3:
                    facilities = facilityService.findMaintenaceList();
                    System.out.println("Display list facility maintenance: ");
                    furamaView.displayMaintenanceFacility(facilities);
                    break;
                case 4:
                    flag = false;
                    break;
                case 5:
                    System.out.println("Return main menu");
                    break;
            }
        }
    }
    public void displayBookingMenu() {
        boolean flag = true;
        List<Booking> bookings;
        Booking book;
        boolean kq;
        while (flag) {
            System.out.println("\nBooking Management: " +
                    "\n1. Add new booking" +
                    "\n2. Display list booking" +
                    "\n3. Return main menu");
            System.out.println("Enter your choice: ");
            int choice = furamaView.InputInt();
            switch (choice) {
                case 1:
                    book = furamaView.addBookingView();
                    kq = bookingService.add(book);
                    if(!kq){
                        System.out.println("Booking ID already exits");
                    }
                    else{
                        System.out.println("Add Booking Success!");
                    }
                    break;
                case 2:
                    bookings = bookingService.findAll();
                    furamaView.displayList(bookings);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    public void displayPromotionMenu(){
        boolean flag =  true;
        List<Customer> customers;
        while(flag) {
            System.out.println("\nPromotion Management: " +
                    "\n1. Display list customers use service" +
                    "\n2. Display list customers get voucher" +
                    "\n3. Return main menu");
            System.out.println("Enter your choice: ");
            int choice = furamaView.InputInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter year: ");
                    int year = furamaView.InputInt();
                    customers = promotionService.displayListCustomerUseService(year);
                    System.out.println("Display list customers use service " + year + ":");
                    furamaView.displayList(customers);
                    break;
                case 2:
                    System.out.println("Voucher 10%: ");
                    int voucher10 =  furamaView.InputInt();
                    System.out.println("Voucher 20%: ");
                    int voucher20 =  furamaView.InputInt();
                    System.out.println("Voucher 50%: ");
                    int voucher50 =  furamaView.InputInt();
                    customers = promotionService.displayListCustomersGetVoucher(voucher10, voucher20, voucher50);
                    furamaView.viewCustomerGetVoucher(customers, voucher10, voucher20, voucher50);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    public void ViewAddFacilityMenu(){
        boolean flag1 = true;
        Facility facility;
        while(flag1) {
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New Room");
            System.out.println("3. Back");
            int choice = furamaView.InputInt();
            if (choice == 1 || choice == 2) {
                facility = furamaView.addFacilityView(choice);
                facilityService.add(facility);
            }
            else{
                flag1 = false;
            }
        }
    }
}

/*
Nguyên lý SOLID: Nguyên lý thiết kế phần mềm
- S: Singleton Responsibility primciple: Nguyên lý trách nhiệm duy nhất
- O: Open-Close principle: Nguyên lý đóng mở, mở rộng chuwcs năng của 1 class nhưng không được sửa code
- L: Liskov nguyên lý thay thế
- I: 1 interface có nhiều phương thức. Tách ra thành nhiều interface mỗi interface có 1 nhiệm vụ nhất định
- D: Dependency Inversion Principle
* */

