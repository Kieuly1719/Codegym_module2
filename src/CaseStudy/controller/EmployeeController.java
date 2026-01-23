package CaseStudy.controller;

import CaseStudy.entity.Employee;
import CaseStudy.service.EmployeeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmployeeController {
    public EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    Scanner sc = new Scanner(System.in);
    public void add() {
        System.out.println("_____________________________________________");
        System.out.println("        Chức năng thêm nhân viên ");

        System.out.print("1. Nhập tên nhân viên: ");
        String name = sc.nextLine();

        System.out.print("2. Nhập CMND: ");
        String CMND = sc.nextLine();

        System.out.print("3. Chọn giới tính (0. Nam, 1. Nữ): ");
        int gtinh = Integer.parseInt(sc.nextLine());

        System.out.print("4. Nhập ngày sinh (dd/mm/yyyy): ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = null;

        while (birthDate == null) {
            try {
                String sDate = sc.nextLine();
                birthDate = sdf.parse(sDate);
            } catch (Exception e) {
                System.out.print("Ngày tháng không hợp lệ! Vui lòng nhập lại (dd/mm/yyyy): ");
            }
        }

        System.out.print("5. Nhập số điện thoại: ");
        String phone = sc.nextLine();

        System.out.print("6. Nhập email: ");
        String email = sc.nextLine();

        System.out.print("7. Trình độ (0. Trung cấp, 1. Cao đẳng, 2. Đại học, 3. Sau đại học): ");
        int level = Integer.parseInt(sc.nextLine());

        System.out.print("8. Vị trí (0. Lễ tân, 1. Phục vụ, 2. Chuyên viên, 3. Giám sát, 4. Quản lý, 5. Giám đốc): ");
        int pos = Integer.parseInt(sc.nextLine());

        System.out.print("9. Lương: ");
        double salary = Double.parseDouble(sc.nextLine());

        Employee nv = new Employee(name, CMND, gtinh, birthDate, phone, email, level, pos, salary);
        employeeService.add(nv);

        System.out.println("---Thông báo: Đã thêm nhân viên thành công---");
        System.out.println("_____________________________________________");
    }
    public void displayListEmployee(){
        System.out.println("_____________________________________________");
        System.out.println("Danh sách nhân viên: ");
        employeeService.display();
        System.out.println("_____________________________________________");
    }
    public void deleteEmployee(){
        displayListEmployee();
        System.out.println("_____________________________________________");
        System.out.print("Chọn nhân viên muốn xóa (Chọn id nhân viên): ");
        int id = sc.nextInt();
        if(employeeService.findEmployee(id) != null){
            Employee e = employeeService.findEmployee(id);
            employeeService.delete(e);
            System.out.println("Đã xóa nhân viên thành công");
            System.out.println("_____________________________________________");
        }
        else{
            System.out.println("Không tìm thấy nhân viên với id: " + id);
        }
    }
    public void editEmployee(){
        displayListEmployee();
        System.out.println("_____________________________________________");
        System.out.print("Chọn nhân viên muốn chỉnh sửa: ");
        int id = sc.nextInt();
        if(employeeService.findEmployee(id) != null){
            Employee e = employeeService.findEmployee(id);
            System.out.println("Chọn thông tin muốn chỉnh sửa: ");
            System.out.println("1. Tên nhân viên");
            System.out.println("2. CMND");
            System.out.println("3. Giới tính");
            System.out.println("4. Ngày sinh");
            System.out.println("5. Số điện thoại");
            System.out.println("6. Email");
            System.out.println("7. Trình độ");
            System.out.println("8. Vị trí");
            System.out.println("9. Lương");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choose = sc.nextInt();
            if(choose == 1){
                System.out.print("Tên nhân viên: ");
                String name = sc.nextLine();
                e.setName(name);
            }
            else if(choose == 2){
                System.out.print("CMND: ");
                String CMND = sc.nextLine();
                e.setCMND(CMND);
            }
            else if(choose == 3){
                System.out.print("Chọn giới tính (0. Nam, 1. Nữ): ");
                int choice = sc.nextInt();
                e.setGtinh(choice);
            }
            else if(choose == 5){
                System.out.print("Nhập số điện thoại");
                String phone = sc.nextLine();
                e.setPhone(phone);
            }
            else if(choose == 6){
                System.out.print("Email: ");
                String email = sc.nextLine();
                e.setEmail(email);
            }
            else if(choose == 7){
                System.out.print("Trình độ (0. Trung cấp, 1. Cao đẳng, 2. Đại học, 3. Sau đại học): ");
                int choice = sc.nextInt();
                e.setLevel(choice);
            }
            else if(choose == 8){
                System.out.print("Vị trí (0. Lễ tân, 1. Phục vụ, 2. Chuyên viên, 3. Giám sát, 4. Quản lý, 5. Giám đốc): ");
                int choice = sc.nextInt();
                e.setPosition(choice);
            }
            else if(choose == 9){
                System.out.print("Lương: ");
                double salary = Double.parseDouble(sc.nextLine());
                e.setSalary(salary);
            }
            else{
                System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
