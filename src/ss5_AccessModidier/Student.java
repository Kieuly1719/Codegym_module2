package ss5_AccessModidier;

public class Student {
    private String name = "John";
    private String classes = "C02";
    public Student(){
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setClasses(String classes) {
        this.classes = classes;
    }
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Mina");
    }
}
