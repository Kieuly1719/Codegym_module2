package ss6_Inheritan.Circle_Cylinder;

public class Cylinder extends Circle {
    public double height;
    public Cylinder(double raidus, String color, double height) {
        super(raidus, color);
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder" +
                "radius: " + this.getRadius() +
                "color: " + this.getColor() +
                "height: " + this.height;
    }
}
