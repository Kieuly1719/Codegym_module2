package ss6_Inheritan.Circle_Cylinder;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(1.0, "yellow");
        Cylinder c2 = new Cylinder(1.0, "red", 65);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
