package FuramaManagement.entity;

import java.time.LocalDate;

public class Customer extends Person{
    private int customer_type; //Diamond, Platinium, Gold, Silver, Member
    private String address;

    public Customer(String ID, String name, LocalDate dateOfBirth, int gender, String CMND, String phone, String email, int customer_type, String address) {
        super(ID, name, dateOfBirth, gender, CMND, phone, email);
        this.customer_type = customer_type;
        this.address = address;
    }

    public Customer() {}

    public int getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(int customer_type) {
        this.customer_type = customer_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStrCustomerType(){
        if(this.getCustomer_type() == 0){
            return "Diamond";
        }
        else if(this.getCustomer_type() == 1){
            return "Platinium";
        }
        else if(this.getCustomer_type() == 2){
            return "Gold";
        }
        else if(this.getCustomer_type() == 3){
            return "Silver";
        }
        else {
            return "Member";
        }
    }
    @Override
    public String displayOb(){
        return "\nEmployee: " +
                "\n1. Employee ID: " + getID() +
                "\n2. Employee name: " + getName() +
                "\n3. BirthDay: " + getDateOfBirth() +
                "\n4. Gender: " + getStrGender() +
                "\n5. CMND: " + getCMND() +
                "\n6. Phone: " + getPhone() +
                "\n7. Email: " + getEmail() +
                "\n8. Type: " + getStrCustomerType() +
                "\n9. Address: " + getAddress();
    }
    @Override
    public String toString() {
        return super.toString() + "," + customer_type + "," + address;
    }
}
