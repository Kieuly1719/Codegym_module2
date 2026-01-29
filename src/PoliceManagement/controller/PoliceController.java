package PoliceManagement.controller;

import PoliceManagement.model.Car;
import PoliceManagement.model.Motorcycle;
import PoliceManagement.model.Truck;
import PoliceManagement.model.Vehicle;
import PoliceManagement.service.IVehicleService;
import PoliceManagement.service.VehicleService;
import PoliceManagement.util.NotFoundVehicleException;
import PoliceManagement.util.Validate;
import PoliceManagement.view.PoliceView;

import java.util.List;
import java.util.Scanner;

public class PoliceController {
    private PoliceView policeView = new PoliceView();
    private IVehicleService  vehicleService = new VehicleService();
    Vehicle vehicle;
    Scanner sc = new Scanner(System.in);
    public void displayMenuMain(){
        boolean flag = true;
        while(flag) {
            System.out.println("------CHUON TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG------");
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm mới phương tiện" +
                    "\n2. Hiển thị phương tiện" +
                    "\n3. Xóa phương tiện" +
                    "\n4. Thoát");
            int choice = Validate.inputInt(sc, "lựa chọn");

            switch (choice) {
                case 1:
                    displayMenuAdd();
                    break;
                case 2:
                    displayMenuVehicle();
                    break;
                case 3:
                    List<Vehicle> list = vehicleService.findAll();
                    policeView.displayIDVehicle(list);
                    String id = InputBKS();
                    System.out.println("Bạn có chắc chắn muốn xóa xe có biển kiểm soát " + id);
                    System.out.println("1. YES" + "\n2. NO");
                    int lc = Validate.inputInt(sc, "lựa chọn");
                    if(lc == 1){
                        if(vehicleService.delete(id)){
                            System.out.println("Đã xóa thành công");
                        }
                    }
                    else{
                        flag = false;
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ, hãy nhập lại!");
                    break;
            }
        }
    }

    private void displayMenuVehicle() {
        boolean flag = true;
        while(flag) {
            System.out.println("Hiển thị phương tiện");
            System.out.println("1. Hiển thị xe tải" +
                    "\n2. Hiển thị oto" +
                    "\n3. Hiển thị xe máy" +
                    "\n4. Thoát");
            int choice = Validate.inputInt(sc, "lựa chọn");
            switch (choice) {
                case 1:
                    List<Truck> truckList= vehicleService.findAllTrucks();
                    policeView.displayList(truckList);
                    break;
                case 2:
                    List<Car> carList =  vehicleService.findAllCars();
                    policeView.displayList(carList);
                    break;
                case 3:
                    List<Motorcycle> motcycleList =  vehicleService.findAllMotorcycles();
                    policeView.displayList(motcycleList);
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Lựa chon không hợp lệ, vui lòng chọn lại!");
                    break;
            }
        }
    }

    public void displayMenuAdd(){
        boolean flag = true;
        boolean kq;
        while(flag) {
            System.out.println("-----Thêm mới phương tiện-----");
            System.out.println("1. Thêm xe tải" +
                    "\n2. Thêm oto" +
                    "\n3. Thêm xe máy" +
                    "\n4. Thoát");
            int choice = Validate.inputInt(sc, "lựa chọn");
            switch (choice) {
                case 1:
                    vehicle = policeView.addVehicle("Truck");
                    kq = vehicleService.add(vehicle);
                    if(kq){
                        System.out.println("Đã thêm thành công");
                    }
                    else {
                        System.out.println("Thêm không thành công");
                    }
                    break;
                case 2:
                    vehicle = policeView.addVehicle("Car");
                    kq  = vehicleService.add(vehicle);
                    if(kq){
                        System.out.println("Đã thêm thành công");
                    }
                    else {
                        System.out.println("Thêm không thành công");
                    }
                    break;
                case 3:
                    vehicle = policeView.addVehicle("Motor");
                    kq = vehicleService.add(vehicle);
                    if(kq){
                        System.out.println("Đã thêm thành công");
                    }
                    else {
                        System.out.println("Thêm không thành công");
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ hãy nhâp lại!");
                    break;
            }
        }

    }
    public String InputBKS() {
        boolean flag = true;
        String bks = "";
        while(flag) {
            try{
                System.out.println("Vui lòng chọn biển kiểm soát bạn muốn xóa: ");
                bks = sc.nextLine();
                if(vehicleService.findById(bks) == null){
                    throw new NotFoundVehicleException("Biển kiểm soát: " + bks +" không tồn tại!");
                }
                flag = false;
            } catch (NotFoundVehicleException e) {
                System.out.println(e.getMessage());
            }
        }
        return bks;
    }
}
