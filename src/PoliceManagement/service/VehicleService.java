package PoliceManagement.service;

import PoliceManagement.model.Car;
import PoliceManagement.model.Motorcycle;
import PoliceManagement.model.Truck;
import PoliceManagement.model.Vehicle;
import PoliceManagement.repository.IVehicleRepository;
import PoliceManagement.repository.VehicleRepository;
import PoliceManagement.util.NotFoundVehicleException;
import PoliceManagement.util.VehicleException;

import java.util.List;

public class VehicleService implements IVehicleService{
    private final IVehicleRepository vehicleRepository = new VehicleRepository();
    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Truck> findAllTrucks() {
        return vehicleRepository.findAllTrucks();
    }

    @Override
    public List<Car> findAllCars() {
        return vehicleRepository.findAllCars();
    }

    @Override
    public List<Motorcycle> findAllMotorcycles() {
        return vehicleRepository.findAllMotorcycles();
    }

    @Override
    public boolean add(Vehicle vehicle) {
        try{
            if(findById(vehicle.getLicense_plate()) != null){
                throw new VehicleException("Biển kiểm soát " + vehicle.getLicense_plate() + " đã tồn tại!");
            }
            vehicleRepository.add(vehicle);
            return true;
        } catch(VehicleException e){
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        if(findById(id) != null){
            vehicleRepository.delete(id);
            return true;
        }
        return false;
    }
    @Override
    public Vehicle findById(String id) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        for (Vehicle v : vehicles) {
            if(v.getLicense_plate().equals(id)){
                return v;
            }
        }
        return null;
    }
}
