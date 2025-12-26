package ss6_Inheritan.Circle_Cylinder;

public class Circle {
    public double raidus;
    public String color;
    public Circle(double raidus, String color) {
        this.raidus = raidus;
        this.color = color;
    }
    @Override
    public String toString(){
        return "Circle:" +
                "radius: " + this.raidus +
                "color: " + this.color;
    }
    public double getRadius() {
        return raidus;
    }
    public String getColor() {
        return color;
    }
}
