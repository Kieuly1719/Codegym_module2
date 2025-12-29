package ss7_AbstractClass_Interface.Bai1;

public class Circle implements Resizeable {
    private double radius;
    public Circle(int radius) {
        this.radius = radius;
    }
    public Circle() {}
    public void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    public void resize(double percent) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Diện tích hình tròn trước khi thay đổi: " + radius*radius*3.14);
        this.radius += this.radius * percent/100;
        System.out.println("Kích thước mới của hình tròn là: " + this.radius);
        System.out.println("Diện tích hình tròn sau khi thay đổi: " + radius*radius*3.14);
        System.out.println("----------------------------------------------------------------");
    }
}
