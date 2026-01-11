package CaseStudy.Entity;

public abstract class AFacilityService {
    public String name_service;
    public double acreage_user;
    public double cost_rent;
    public int max_tenants;
    public int type_rent; //1: năm, 2: tháng, 3: ngày
    public int type_service; //1: Villa, 2: Room

    public AFacilityService(String name_service, double acreage_user, double cost_rent, int max_tenants, int type_rent, int type_service) {
        this.name_service = name_service;
        this.acreage_user = acreage_user;
        this.cost_rent = cost_rent;
        this.max_tenants = max_tenants;
        this.type_rent = type_rent;
        this.type_service = type_service;
    }

    public abstract void displayInformation();

}
