package CaseStudy.entity;

public class Villa extends AFacility {
    private String tcp; //tieu chuẩn phòng
    private double acreage;
    private int floors;

    public Villa(String name_service, double acreage_user, double cost_rent, int max_tenants, int type_rent, String tcp, double acreage, int floors) {
        super(name_service, acreage_user, cost_rent, max_tenants, type_rent, 1);
        this.tcp = tcp;
        this.acreage = acreage;
        this.floors = floors;
    }

    public String getTcp() {
        return tcp;
    }

    public void setTcp(String tcp) {
        this.tcp = tcp;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
}
