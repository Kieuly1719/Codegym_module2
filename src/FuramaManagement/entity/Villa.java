package FuramaManagement.entity;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int floors;

    public Villa(String service_id, String service_name, double useArea, double rentCost, int max_user, int type, String roomStandard, double poolArea, int floors) {
        super(service_id, service_name, useArea, rentCost, max_user, type);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public Villa(){}

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
    @Override
    public String displayOb(){
        return "\nVilla " + getService_name() +
        "\n1. Service ID: " + getService_id() +
        "\n2. Service name: " + getService_name() +
        "\n3. Usable Area: " + getUseArea() +
        "\n4. Rent Cost: " + getRentCost() +
        "\n5. Max User: " + getMax_user() +
        "\n6. Type: " + getStrType() +
        "\n7. Room Standard: " + getRoomStandard() +
        "\n8. Pool Area: " + getPoolArea() +
        "\n9. Floors: " + getFloors();
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                roomStandard + "," +
                poolArea + "," +
                floors;
    }
}
