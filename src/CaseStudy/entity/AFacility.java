package CaseStudy.entity;

public abstract class AFacility {
    private String name_service;
    private double acreage_user;
    private double cost_rent;
    private int max_tenants;
    private int type_rent; //1: năm, 2: tháng, 3: ngày
    private int type_service; //1: Villa, 2: Room

    public AFacility(String name_service, double acreage_user, double cost_rent, int max_tenants, int type_rent, int type_service) {
        this.name_service = name_service;
        this.acreage_user = acreage_user;
        this.cost_rent = cost_rent;
        this.max_tenants = max_tenants;
        this.type_rent = type_rent;
        this.type_service = type_service;
    }

    public String getName_service() {
        return name_service;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public double getAcreage_user() {
        return acreage_user;
    }

    public void setAcreage_user(double acreage_user) {
        this.acreage_user = acreage_user;
    }

    public double getCost_rent() {
        return cost_rent;
    }

    public void setCost_rent(double cost_rent) {
        this.cost_rent = cost_rent;
    }

    public int getMax_tenants() {
        return max_tenants;
    }

    public void setMax_tenants(int max_tenants) {
        this.max_tenants = max_tenants;
    }

    public int getType_rent() {
        return type_rent;
    }

    public void setType_rent(int type_rent) {
        this.type_rent = type_rent;
    }

    public int getType_service() {
        return type_service;
    }

    public void setType_service(int type_service) {
        this.type_service = type_service;
    }
}
