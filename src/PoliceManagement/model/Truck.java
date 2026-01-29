package PoliceManagement.model;

public class Truck extends Vehicle {
    private double load_capacity;

    public Truck(String license_plate, String manufacturer_name, int manufacturer_year, String owner, double load_capacity) {
        super(license_plate, manufacturer_name, manufacturer_year, owner);
        this.load_capacity = load_capacity;
    }

    public double getLoad_capacity() {
        return load_capacity;
    }

    public void setLoad_capacity(double load_capacity) {
        this.load_capacity = load_capacity;
    }
    @Override
    public String toString() {
        return super.toString() + "," + load_capacity;
    }
    @Override
    public String displayVehicle() {
        return super.displayVehicle() +
                "\n5. Trọng tải: " + load_capacity;
    }
}
