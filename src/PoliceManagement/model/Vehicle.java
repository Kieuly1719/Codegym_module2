package PoliceManagement.model;

import FuramaManagement.entity.Facility;

import java.util.Objects;

public abstract class Vehicle implements IDisplay{
    private String license_plate;
    private String manufacturer_name;
    private int manufacturer_year;
    private String owner;

    public Vehicle(String license_plate, String manufacturer_name, int manufacturer_year, String owner) {
        this.license_plate = license_plate;
        this.manufacturer_name = manufacturer_name;
        this.manufacturer_year = manufacturer_year;
        this.owner = owner;
    }
    public Vehicle(){}

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public int getManufacturer_year() {
        return manufacturer_year;
    }

    public void setManufacturer_year(int manufacturer_year) {
        this.manufacturer_year = manufacturer_year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(license_plate, vehicle.license_plate);
    }
    @Override
    public String toString() {
        return license_plate + "," +
                manufacturer_name + "," +
                manufacturer_year+ "," +
                owner;
    }
    @Override
    public String displayVehicle() {
        return "1. Biển kiểm soát: " + license_plate +
                "\n2. Tên nhà sản xuất: " + manufacturer_name +
                "\n3. Năm sản xuất: " + manufacturer_year +
                "\n4. Chủ sỡ hữu: " + owner;
    }
}
