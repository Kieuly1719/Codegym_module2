package PoliceManagement.view;

import PoliceManagement.model.*;
import PoliceManagement.util.Validate;

import java.util.List;
import java.util.Scanner;

public class PoliceView {
    Scanner sc = new Scanner(System.in);
    Vehicle vehicle;
    public Vehicle addVehicle(String name){
        System.out.println("Thông tin cần thêm mới");
        System.out.println("1. Biển kiểm soát: ");
        String bks;
        if (name.equals("Truck")){
            bks = Validate.inputAndValidatePlate(sc, 0);
        }
        else if(name.equals("Car")){
            bks = Validate.inputAndValidatePlate(sc, 1);
        }
        else{
            bks = Validate.inputAndValidatePlate(sc, 2);
        }
        System.out.println("2. Hãng sản xuất: ");
        String hsx =  sc.nextLine();
        System.out.print("3. ");
        int year = Validate.inputInt(sc, "Năm sản xuât");
        System.out.println("4. Chủ số hữu: ");
        String owner = sc.nextLine();
        if(name.equals("Truck")){
            System.out.print("5. ");
            double load_capacity = Validate.inputInt(sc, "Tải trọng");
            vehicle = new Truck(bks, hsx, year, owner, load_capacity);
        }
        if(name.equals("Car")){
            System.out.print("5. ");
            int type = Validate.inputInt(sc, "Kiểu xe: ");
            System.out.print("6. ");
            int number_of_seats = Validate.inputInt(sc, "Số chỗ ngồi");
            vehicle = new Car(bks, hsx, year, owner, type, number_of_seats);
        }
        if(name.equals("Motor")){
            System.out.print("5. ");
            int power = Validate.inputInt(sc, "Công suất");
            vehicle = new Motorcycle(bks, hsx, year, owner, power);
        }
        return vehicle;
    }

    public <T extends IDisplay> void displayList(List<T> list) {
        for (T t : list){
            System.out.println("--------------------------------------------------");
            System.out.println("Thông tin xe: ");
            System.out.println(t.displayVehicle());
            System.out.println("--------------------------------------------------");
        }
    }

    public void displayIDVehicle(List<Vehicle> list) {
        StringBuilder Trucks = new StringBuilder();
        StringBuilder Cars = new StringBuilder();
        StringBuilder Motorcycles = new StringBuilder();
        Trucks.append("Xe tải: \n");
        Cars.append("Xe oto: \n");
        Motorcycles.append("Xe máy: \n");
        for (Vehicle vehicle : list){
            if(vehicle instanceof Truck){
                Trucks.append(vehicle.getLicense_plate());
                Trucks.append(" | ");
            }
            else if(vehicle instanceof Car){
                Cars.append(vehicle.getLicense_plate());
                Cars.append(" | ");
            }
            else if(vehicle instanceof Motorcycle){
                Motorcycles.append(vehicle.getLicense_plate());
                Motorcycles.append(" | ");
            }
        }
        System.out.println(Trucks.toString());
        System.out.println(Cars.toString());
        System.out.println(Motorcycles.toString());
    }
}
