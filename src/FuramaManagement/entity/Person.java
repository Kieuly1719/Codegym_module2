package FuramaManagement.entity;

import FuramaManagement.util.DateConverter;

import java.time.LocalDate;
import java.util.Date;

public abstract class Person implements IDisplay {
    private String ID;
    private String name;
    private LocalDate dateOfBirth;
    private int gender; //0. Nam, 1. Nu
    private String CMND;
    private String phone;
    private String email;

    public Person(String ID, String name, LocalDate dateOfBirth, int gender, String CMND, String phone, String email) {
        this.ID = ID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.CMND = CMND;
        this.phone = phone;
        this.email = email;
    }

    public Person() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
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
    public String getStrGender(){
        if(gender == 0){
            return "Male";
        }
        else {
            return "female";
        }
    }
    @Override
    public String toString() {
        return ID + "," + name + "," + DateConverter.dateToString(dateOfBirth) + "," + gender + "," + CMND + "," + phone + "," + email;
    }
}
