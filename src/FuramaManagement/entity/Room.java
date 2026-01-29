package FuramaManagement.entity;

public class Room extends Facility{
    private String service_free;

    public Room(String service_id, String service_name, double useArea, double rentCost, int max_user, int type, String service_free) {
        super(service_id, service_name, useArea, rentCost, max_user, type);
        this.service_free = service_free;
    }

    public Room(){}

    public String getService_free() {
        return service_free;
    }

    public void setService_free(String service_free) {
        this.service_free = service_free;
    }
    @Override
    public String displayOb(){
        return "\nRoom " + getService_name() +
                "\n1. Service ID: " + getService_id() +
                "\n2. Service name: " + getService_name() +
                "\n3. Usable Area: " + getUseArea() +
                "\n4. Rent Cost: " + getRentCost() +
                "\n5. Max User: " + getMax_user() +
                "\n6. Type: " + getStrType() +
                "\n7. Service free: " + getService_free();
    }
    @Override
    public String toString() {
         return super.toString() + "," +
                 service_free;
    }
}
