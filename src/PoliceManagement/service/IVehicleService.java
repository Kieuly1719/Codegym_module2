package PoliceManagement.service;

import PoliceManagement.model.Car;
import PoliceManagement.model.Motorcycle;
import PoliceManagement.model.Truck;
import PoliceManagement.model.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<Vehicle> findAll();
    List<Truck> findAllTrucks();
    List<Car> findAllCars();
    List<Motorcycle> findAllMotorcycles();
    boolean add(Vehicle vehicle);
    boolean delete(String id);
    Vehicle findById(String id);
}
