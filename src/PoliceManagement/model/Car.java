package PoliceManagement.model;

public class Car extends Vehicle {
    private int number_of_seats;
    private int type;//0. du lịch, 1. xe khách

    public Car(String license_plate, String manufacturer_name, int manufacturer_year, String owner, int number_of_seats, int type) {
        super(license_plate, manufacturer_name, manufacturer_year, owner);
        this.number_of_seats = number_of_seats;
        this.type = type;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return super.toString() + "," +
                number_of_seats + "," +
                type;
    }
    @Override
    public String displayVehicle() {
        return super.displayVehicle() +
                "\n5. Số ghế ngồi: " + number_of_seats +
                "\n6. Loại xe: " + type;
    }
}
