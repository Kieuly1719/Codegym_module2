package ss15_HandleException;

public class Triangle {
    private double c1;
    private double c2;
    private double c3;
    public Triangle(double c1, double c2, double c3) throws IllegalTriangleException {
        if(c1 <= 0 || c2 <= 0 || c3 <= 0 || (c1+c2 <= c3) || (c1+c3 <= c2) || (c2+c3<= c1)){
            throw new IllegalTriangleException(c1,c2,c3);
        }
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }
    @Override
    public String toString() {
        return "Tam giác hợp lệ: [" + c1 + ", " + c2 + ", " + c3 + "]";
    }
}
