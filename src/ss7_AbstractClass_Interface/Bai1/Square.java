package ss7_AbstractClass_Interface.Bai1;

import java.util.LinkedHashSet;

public class Square implements Resizeable {
    double cd;
    public Square(int cd) {
        this.cd = cd;
    }
    public Square() {}
    @Override
    public void resize(double percent) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Diện tích hình vuông trước khi thay đổi: " + cd*cd);
        cd += cd*percent/100;
        System.out.println("Kích thước mới của hình vuông là: " + this.cd);
        System.out.println("Diện tích hình tròn sau khi thay đổi: " + cd*cd);
        System.out.println("----------------------------------------------------------------");
    }
}
