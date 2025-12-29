package ss7_AbstractClass_Interface.Bai2;

public class Squarenew implements Colorable {
    double radius;
    public Squarenew(double radius) {
        this.radius = radius;
    }
    public Squarenew() {}
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
        System.out.println("------------------------------------------------------");
    }
    @Override
    public String toString(){
        return "Diện tích hình tròn: " + radius*radius + "\n";
    }
}
