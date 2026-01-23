package CaseStudy.entity;

import java.util.Date;

public class Customer extends APerson{
    private static int count = 0;
    private int idCus;
    private int CusType;
    private String address;

    public Customer(String name,String CMND, int gtinh, Date birthDate, String phone, String email, int idCus, int CusType, String address) {
        super(name, CMND, gtinh, birthDate, phone, email);
        this.idCus = count++;
        this.CusType = CusType;
        this.address = address;
    }

    public int getIdCus() {
        return idCus;
    }


    public int getCusType() {
        return CusType;
    }

    public void setCusType(int cusType) {
        CusType = cusType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
