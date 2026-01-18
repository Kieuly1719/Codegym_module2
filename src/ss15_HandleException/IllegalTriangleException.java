package ss15_HandleException;

public class IllegalTriangleException extends Exception{
    private double c1,c2,c3;
    public IllegalTriangleException(String message){
        super(message);
    }
    public IllegalTriangleException(double c1, double c2, double c3){
        super("Tam giác không hợp lệ với 3 canh: " + c1 + ", " + c2 + ", " + c3);
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public double getC1() {
        return c1;
    }

    public double getC2() {
        return c2;
    }

    public double getC3() {
        return c3;
    }
}
