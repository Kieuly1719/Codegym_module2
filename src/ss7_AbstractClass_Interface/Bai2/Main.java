package ss7_AbstractClass_Interface.Bai2;
public class Main {
    public static void main(String[] args) {
        Squarenew[] squareArray = new Squarenew[4];
        squareArray[0] = new Squarenew(2.0);
        squareArray[1] = new Squarenew(1.0);
        squareArray[2] = new Squarenew(3.5);
        squareArray[3] = new Squarenew(1.2);

        System.out.println("Bắt đầu duyệt mảng:");
        for(Squarenew sq : squareArray){
            System.out.println(sq);
            sq.howToColor();
        }
    }
}
