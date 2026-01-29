package FuramaManagement.entity;

import java.time.LocalDate;
import java.util.Date;

public class Employee extends Person{
    private int level;
    private int position;
    private double salary;

    public Employee(String ID, String name, LocalDate dateOfBirth, int gender, String CMND, String phone, String email, int level, int position, double salary) {
        super(ID, name, dateOfBirth, gender, CMND, phone, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee() {}

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStrLevel(){
        if(this.level==1){
            return "Trung cấp";
        }
        else if(this.level==2){
            return "Cao đẳng";
        }
        else if(this.level==3){
            return "Đại học";
        }
        else{
            return "Sau đại học";
        }
    }

    public String getStrPosition(){
        if(this.position==1){
            return "Lễ tân";
        }
        else if(this.position==2){
            return "Phục vụ";
        }
        else if(this.position==3){
            return "Chuyên viên";
        }
        else if (this.position==4){
            return "Giám sát";
        }
        else if(this.position==5){
            return "Quản lý";
        }
        else{
            return "Giám đốc";
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
                "\n8. Level: " + getStrLevel() +
                "\n9. Position: " + getStrPosition() +
                "\n10. Salary: " + getSalary();
    }
    @Override
    public String toString() {
        return super.toString() + "," + level + "," + position + "," + salary;
    }
}
