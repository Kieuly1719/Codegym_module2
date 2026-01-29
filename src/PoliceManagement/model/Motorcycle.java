package PoliceManagement.model;

public class Motorcycle extends Vehicle{
    private double power;

    public Motorcycle(String license_plate, String manufacturer_name, int manufacturer_year, String owner, double power) {
        super(license_plate, manufacturer_name, manufacturer_year, owner);
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
    @Override
    public String toString() {
        return super.toString() + "," + power;
    }
    @Override
    public String displayVehicle() {
        return super.displayVehicle() +
                "\n5. Công suất: " + power;
    }
}
