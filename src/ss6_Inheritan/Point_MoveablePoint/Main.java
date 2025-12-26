package ss6_Inheritan.Point_MoveablePoint;

public class Main {
    public static void main(String[] args) {
        MovablePoint p1 = new MovablePoint(1, 2);
        Point p2 = new Point(5, 2);
        MovablePoint p3 = new MovablePoint(4, 3, 0, 2);
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
    }
}
