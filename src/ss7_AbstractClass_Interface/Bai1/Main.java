package ss7_AbstractClass_Interface.Bai1;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        Rectangle rectangle = new Rectangle(2,5);
        Square square = new Square(4);

        circle.resize(30);
        rectangle.resize(40);
        square.resize(20);
    }
}
