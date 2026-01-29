package PoliceManagement.repository;

import PoliceManagement.model.Car;
import PoliceManagement.model.Motorcycle;
import PoliceManagement.model.Truck;
import PoliceManagement.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    List<Truck> findAllTrucks();
    List<Car> findAllCars();
    List<Motorcycle> findAllMotorcycles();
    void add(Vehicle vehicle);
    void delete(String id);
}
