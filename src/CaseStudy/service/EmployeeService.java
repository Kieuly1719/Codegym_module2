package CaseStudy.service;

import CaseStudy.entity.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private Scanner sc = new Scanner(System.in);
    private static ArrayList<Employee> employees;
    public EmployeeService(ArrayList<Employee> employees) {

    }
    @Override
    public void add(Employee e) {
        employees.add(e);
    }

    @Override
    public void display() {
        for(Employee e: employees) {
            System.out.println(e);
        }
    }

    @Override
    public void edit(Employee e) {
        employees.remove(e);
        employees.add(e);
    }

    @Override
    public void delete(Employee e) {
        employees.remove(e);
    }
    public Employee findEmployee(int id){
        for(Employee e: employees){
            if(e.getIdNv() == id){
                return e;
            }
        }
        return null;
    }
}