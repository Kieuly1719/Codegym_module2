package CaseStudy.entity;

import java.util.Date;

public abstract class APerson {
    protected String name;
    protected String CMND;
    protected int gtinh;
    protected Date birthDate;
    protected String phone;
    protected String email;
    protected APerson() {}

    public APerson(String name, String CMND, int gtinh, Date birthDate, String phone, String email) {
        this.name = name;
        this.CMND = CMND;
        this.gtinh = gtinh;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public int getGtinh() {
        return gtinh;
    }

    public void setGtinh(int gtinh) {
        this.gtinh = gtinh;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
