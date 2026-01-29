package FuramaManagement.view;

import FuramaManagement.entity.*;
import FuramaManagement.util.DateConverter;
import FuramaManagement.util.UserException;
import FuramaManagement.util.Validate;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FuramaView {
    Scanner sc = new Scanner(System.in);
    public FuramaView() {}
    public <T extends IDisplay> void displayList(List<T> list){
        System.out.println("______________________________________________________");
        for(T item : list){
            System.out.println(item.displayOb());
        }
        System.out.println("______________________________________________________");
    }
    public void displayListFacility(Map<Facility, Integer> facilities) {
        if (facilities.isEmpty()) {
            System.out.println("There is no facilities");
        }
        else{
            for(Map.Entry<Facility, Integer> entry : facilities.entrySet()){
                System.out.println("Service: " + entry.getKey().toString());
                System.out.println("Usage: " + entry.getValue());
                System.out.println("-------------------");
            }
        }
    }
    public void displayMaintenanceFacility(Map<Facility, Integer> maintenances) {
        if (maintenances.isEmpty()) {
            System.out.println("There is no maintenances");
        }
        else{
            for(Map.Entry<Facility, Integer> entry : maintenances.entrySet()){
                System.out.println(entry.getKey().toString() + " - Used: " + entry.getValue());
            }
        }
    }

    public void viewCustomerGetVoucher(List<Customer> customers, int voucher10, int voucher20, int voucher50) {
        System.out.println("__________________________________________________");
        System.out.println("List of Vouchers: ");

        int currentIndex = 0;
        int totalCustomers = customers.size();

        System.out.println("\n--- Voucher 10% ---");
        for (int i = 0; i < voucher10; i++) {
            if (currentIndex >= totalCustomers) break;

            System.out.println(customers.get(currentIndex).displayOb());
            currentIndex++;
        }

        if (currentIndex < totalCustomers) {
            System.out.println("\n--- Voucher 20% ---");
            for (int i = 0; i < voucher20; i++) {
                if (currentIndex >= totalCustomers) break;

                System.out.println(customers.get(currentIndex).displayOb());
                currentIndex++;
            }
        }

        if (currentIndex < totalCustomers) {
            System.out.println("\n--- Voucher 50% ---");
            for (int i = 0; i < voucher50; i++) {
                if (currentIndex >= totalCustomers) break;

                System.out.println(customers.get(currentIndex).displayOb());
                currentIndex++;
            }
        }

        System.out.println("__________________________________________________");
    }

    public Employee addEmployeeView(){
        System.out.println("\n----ADD NEW EMPLOYEE----");
        System.out.println("Employee ID: ");
        String id = sc.nextLine();
        String name = inputNameStandard("Employee Name");
        String date = inputDate("Date of Birth");
        System.out.println("Gender (0. Male, 1. Female): ");
        int gender = InputInt();
        System.out.println("CMND: ");
        String cmnd =  sc.nextLine();
        System.out.println("Phone: ");
        String phone = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Level (1. Trung cấp, 2. Cao đăng, 3. Đại học, 4. Sau đại học): ");
        int level = InputInt();
        System.out.println("Position (1. Lễ tân, 2. Phục vụ, 3. Chuyên viên, 4. Giám sát, 5. Quản lý, 6. Giám đốc): ");
        int position = InputInt();
        System.out.println("Salary: ");
        double mc = sc.nextDouble();
        return new Employee(id, name, DateConverter.stringToDate(date), gender, cmnd, phone, email, level, position, mc);
    }
    public Customer addCustomerView(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Infomation Employee");
        System.out.println("Employee ID: ");
        String id = sc.nextLine();
        String name = inputNameStandard("Customer Name");
        String date = inputDate("Date of Birth");
        System.out.println("Gender (0. Male, 1. Female): ");
        int gender = InputInt();
        System.out.println("CMND: ");
        String cmnd =  sc.nextLine();
        System.out.println("Phone: ");
        String phone = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Type(1. Diamond, 2. Platinium, 3. Gold, 4. Silver, 5. Member):");
        int type = InputInt();
        System.out.println("Address: ");
        String address = sc.nextLine();
        return new Customer(id, name, DateConverter.stringToDate(date), gender, cmnd, phone, email, type, address);
    }
    public Booking addBookingView(){
        System.out.println("Infomation Booking");
        System.out.println("Booking ID: ");
        String id = sc.nextLine();
        String startDate = inputDate("Start Date");
        String endDate = inputDate("End Date");
        System.out.println("Customer ID: ");
        String customerID = sc.nextLine();
        System.out.println("Service Name: ");
        String serviceName = sc.nextLine();
        return new Booking(id,DateConverter.stringToDate(startDate), DateConverter.stringToDate(endDate), customerID, serviceName);
    }
    public Facility addFacilityView(int choice){
        String serviceID;
        if(choice == 1){
            serviceID = InputIdVilla();
        }
        else{
            serviceID = inputIdRoom();
        }
        String serviceName = inputNameStandard("Service Name");
        double useArea = inputArea("Use Area");
        double cost = inputCost();
        int maxPeople = inputMaxPeople();
        System.out.println("Type rent (1.Year, 2.Month, 3.Day): ");
        int rentType = InputInt();
        Facility newFacility;
        if(choice == 1){
            String standard = inputNameStandard("Standard");
            double poolArea = inputArea("Pool Area");
            int floors = inputFloors();
            newFacility = new Villa(serviceID, serviceName, useArea, cost, maxPeople, rentType, standard, poolArea, floors);
        }
        else{
            System.out.print("Free Service: ");
            String free = sc.nextLine();
            newFacility = new Room(serviceID, serviceName, useArea, cost, maxPeople, rentType, free);
        }
        return newFacility;
    }

    public String InputIdVilla(){
        while(true){
            try {
                System.out.print("Nhập Mã Villa (SVVL-YYYY): ");
                String id = sc.nextLine();
                Validate.validateRegex(id, Validate.getRegexIdVilla(), "Lỗi: Mã Villa sai định dạng SVVL-YYYY!");
                return id;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private String inputIdRoom() {
        while (true) {
            try {
                System.out.print("Nhập Mã Room (SVRO-YYYY): ");
                String id = sc.nextLine();
                Validate.validateRegex(id, Validate.getRegexIdRoom(), "Lỗi: Mã Room sai định dạng SVRO-YYYY!");
                return id;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public String InputID(){
        System.out.println("Nhập ID: ");
        String id = sc.nextLine();
        return id;
    }
    public int InputInt(){
        while(true){
            try{
                return Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ");
            }
        }
    }
    private double inputArea(String fieldName) {
        while (true) {
            try {
                System.out.print("Nhập " + fieldName + " (>30m2): ");
                double area = Double.parseDouble(sc.nextLine());
                Validate.validateArea(area);
                return area;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private double inputCost() {
        while (true) {
            try {
                System.out.print("Nhập Chi phí thuê (Dương): ");
                double cost = Double.parseDouble(sc.nextLine());
                Validate.validateCost(cost);
                return cost;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private int inputMaxPeople() {
        while (true) {
            try {
                System.out.print("Nhập Số người tối đa (0-20): ");
                int people = Integer.parseInt(sc.nextLine());
                Validate.validateMaxPeople(people);
                return people;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên!");
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputFloors() {
        while (true) {
            try {
                System.out.print("Nhập Số tầng (Nguyên dương): ");
                int floors = Integer.parseInt(sc.nextLine());
                Validate.validateFloors(floors);
                return floors;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên!");
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private String inputNameStandard(String fieldName) {
        while (true) {
            try {
                System.out.print(fieldName + " (Viết hoa chữ đầu): ");
                String str = sc.nextLine();
                Validate.validateRegex(str, Validate.getRegexName(), "Lỗi: Phải viết hoa ký tự đầu mỗi từ!");
                return str;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private String inputDate(String fieldName) {
        while (true) {
            try {
                System.out.print("Input " + fieldName + " (dd/MM/yyyy): ");
                String date = sc.nextLine();

                if (fieldName.toLowerCase().contains("birth")) {
                    Validate.validateBirthday(date);
                }
                if (DateConverter.stringToDate(date) == null) throw new Exception();

                return date;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Lỗi: Định dạng ngày sai (dd/MM/yyyy)!");
            }
        }
    }
}
