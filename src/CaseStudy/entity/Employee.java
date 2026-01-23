package CaseStudy.entity;

import java.util.Date;

public class Employee extends APerson{
    private static int count = 0;
    private int idNv;
    private int level;
    private int Position;
    private double Salary;
    public Employee(String name, String CMND, int gtinh, Date birthDate, String phone, String email, int level, int Pos, double Salary){
        super(name, CMND, gtinh, birthDate, phone, email);
        this.idNv = count++;
        this.level = level;
        this.Position = Pos;
        this.Salary = Salary;
    }

    public int getIdNv() {
        return idNv;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }
}
