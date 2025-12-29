package ss7_AbstractClass_Interface.Bai1;

public class Rectangle implements Resizeable {
    double width;
    double height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public Rectangle() {}
    @Override
    public void resize(double percent) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Diện tích hình chữ nhật trước khi thay đổi: " + width*height);
        width += width*percent/100;
        height += height*percent/100;
        System.out.println("Chiều rộng mới của hình chữ nhật là: " + this.width + " và chiều dài là: " + this.height);
        System.out.println("Diện tích hình tròn sau khi thay đổi: " + width*height);
        System.out.println("----------------------------------------------------------------");
    }
}
