package FuramaManagement.entity;

import java.util.Objects;

public abstract class Facility implements IDisplay{
    private String service_id;
    private String service_name;
    private double useArea;
    private double rentCost;
    private int max_user;
    private int type;

    public Facility(String service_id, String service_name, double useArea, double rentCost, int max_user, int type) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.useArea = useArea;
        this.rentCost = rentCost;
        this.max_user = max_user;
        this.type = type;
    }

    public Facility() {}

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getMax_user() {
        return max_user;
    }

    public void setMax_user(int max_user) {
        this.max_user = max_user;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStrType(){
        if(type == 1){
            return "Year";
        }
        else if(type == 2){
            return "Month";
        } else {
            return "Day";
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(service_id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Facility facility = (Facility) obj;
        return Objects.equals(service_id, facility.service_id);
    }
    @Override
    public String toString() {
        return service_id + "," +
                service_name + "," +
                useArea + "," +
                rentCost + "," +
                max_user + "," +
                type;
    }
}
