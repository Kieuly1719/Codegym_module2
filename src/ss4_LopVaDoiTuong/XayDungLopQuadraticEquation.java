package ss4_LopVaDoiTuong;

import java.util.Scanner;

public class XayDungLopQuadraticEquation {
    private double a;
    private double b;
    private double c;

    public XayDungLopQuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }
    public double getDiscriminant(){
        return b*b - 4*a*c;
    }
    public double getRoot1(){
        if(getDiscriminant() >= 0){
            return (-b + Math.sqrt(getDiscriminant()))/(2*a);
        }
        else{
            return 0;
        }
    }
    public double getRoot2(){
        if(getDiscriminant() >= 0){
            return (-b - Math.sqrt(getDiscriminant()))/(2*a);
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.print("Nhập a: ");
        Scanner sca = new Scanner(System.in);
        double a = sca.nextDouble();
        System.out.print("Nhập b: ");
        Scanner scb = new Scanner(System.in);
        double b = scb.nextDouble();
        System.out.print("Nhập c: ");
        Scanner scc = new Scanner(System.in);
        double c = scc.nextDouble();

        XayDungLopQuadraticEquation pt1 = new XayDungLopQuadraticEquation(a, b, c);
        if (pt1.getDiscriminant() > 0) {
            System.out.println("The equation has two roots " + pt1.getRoot1() + " and " + pt1.getRoot2());
        }
        else if(pt1.getDiscriminant() == 0){
            System.out.println("The equation has one root: " + pt1.getRoot1());
        }
        else{
            System.out.println("The equation has no real roots");
        }
    }
}
