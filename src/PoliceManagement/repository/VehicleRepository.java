package PoliceManagement.repository;

import PoliceManagement.model.Car;
import PoliceManagement.model.Motorcycle;
import PoliceManagement.model.Truck;
import PoliceManagement.model.Vehicle;
import PoliceManagement.util.VehicleException;
import PoliceManagement.util.WriteAndReadFile;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements IVehicleRepository{
    private static final String TRUCK_FILE = "src/PoliceManagement/data/xeTai.csv";
    private static final String CAR_FILE = "src/PoliceManagement/data/oto.csv";
    private static final String MOTOR_FILE = "src/PoliceManagement/data/xeMay.csv";

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        List<Car> cars = findAllCars();
        List<Motorcycle> motorcycles = findAllMotorcycles();
        List<Truck> trucks = findAllTrucks();

        for(Truck truck : trucks){
            vehicles.add((Vehicle) truck);
        }
        for(Car car : cars){
            vehicles.add((Vehicle) car);
        }
        for( Motorcycle motorcycle : motorcycles){
            vehicles.add((Vehicle) motorcycle);
        }

        return vehicles;
    }

    @Override
    public List<Truck> findAllTrucks() {
        List<String> trucks = WriteAndReadFile.ReadFile(TRUCK_FILE);
        List<Truck> truckList = new ArrayList<>();
        String[] parts = null;
        for(String truck : trucks){
            if (truck.trim().isEmpty()) continue;
            parts = truck.split(",");
            truckList.add(new Truck(parts[0], parts[1], Integer.parseInt(parts[2].trim()), parts[3], Double.parseDouble(parts[4].trim())));
        }
        return truckList;
    }

    @Override
    public List<Car> findAllCars() {
        List<String> cars = WriteAndReadFile.ReadFile(CAR_FILE);
        List<Car> carList = new ArrayList<>();
        String[] parts = null;
        for(String car : cars){
            if (car.trim().isEmpty()) continue;
            parts = car.split(",");
            carList.add(new Car(parts[0], parts[1], Integer.parseInt(parts[2].trim()), parts[3], Integer.parseInt(parts[4].trim()), Integer.parseInt(parts[5].trim())));
        }
        return carList;
    }

    @Override
    public List<Motorcycle> findAllMotorcycles() {
         List<String> motors = WriteAndReadFile.ReadFile(MOTOR_FILE);
        List<Motorcycle> motorcycleList = new ArrayList<>();
        String[] parts = null;
        for(String motor : motors){
            if (motor.trim().isEmpty()) continue;
            parts = motor.split(",");
            motorcycleList.add(new Motorcycle(parts[0], parts[1], Integer.parseInt(parts[2].trim()), parts[3], Double.parseDouble(parts[4].trim())));
        }
        return motorcycleList;
    }

    @Override
    public void add(Vehicle vehicle) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        if(vehicle instanceof Truck){
            WriteAndReadFile.WriteToFile(TRUCK_FILE, vehicles, true);
        }
        else if(vehicle instanceof Car){
            WriteAndReadFile.WriteToFile(CAR_FILE, vehicles, true);
        }
        else if(vehicle instanceof Motorcycle){
            WriteAndReadFile.WriteToFile(MOTOR_FILE, vehicles, true);
        }
    }

    @Override
    public void delete(String id) {
        List<Vehicle> vehicles = findAll();
        List<Vehicle> newVehicle = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if(vehicle.getLicense_plate().equals(id)){
                continue;
            }
            newVehicle.add(vehicle);
        }
        WriteAndReadFile.WriteToFile(TRUCK_FILE, newVehicle, false);
    }

}
