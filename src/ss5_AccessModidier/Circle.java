package ss5_AccessModidier;

public class Circle {
    private double raidus = 1.0;
    private String color = "red";

    public Circle() {

    }
    public Circle(double r) {
        this.raidus = r;
    }
    public double getRaidus() {
        return raidus;
    }
    public double getArea(){
        return raidus * raidus;
    }
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.0);
        System.out.println(c1.getRaidus());
        System.out.println(c2.getRaidus());
        System.out.println(c1.getArea());
        System.out.println(c2.getArea());
    }
}
