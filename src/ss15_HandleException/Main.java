package ss15_HandleException;

public class Main {
    public static void main(String[] args) {
        try{
            Triangle t1 = new Triangle(3,4,5);
            System.out.println(t1);
            Triangle t2 = new Triangle(1,2,10);
            System.out.println(t2);
        } catch (IllegalTriangleException e) {
            System.err.print("Lỗi: " + e.getMessage());
        }
    }
}
