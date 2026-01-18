package ss16_IOTextFile.Demo.Service;

import ss16_IOTextFile.Demo.Entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public static void main(String[] args) {
          List<Student> students = new ArrayList<>();
//        students.add(new Student("Alice", 20, "123 Main St", "alice@gmail.com"));
//        students.add(new Student("Bob", 22, "456 Oak Ave", "bob@yahoo.com"));
//        students.add(new Student("Charlie", 19, "789 Pine Rd", "charlie@gmail.com"));
//        String filePath = "src/ss16_IOTextFile/Demo/files/students.csv";
//        writeStudentsToCSV(students, filePath);
        String filePathNew =  "src/ss16_IOTextFile/Demo/files/students.csv";
        readStudentsToCSV(filePathNew);
    }
    private static void readStudentsToCSV(String filePath){
        try(FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)){
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 4){
                    Student student = new Student();
                    student.setName(data[0]);
                    student.setAge(Integer.parseInt(data[1]));
                    student.setAddress(data[2]);
                    student.setEmail(data[3]);
                    System.out.println(student.toString());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void writeStudentsToCSV(List<Student> students, String filePath){
        try(FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write("Name, Age, Address, Email"); // Write header
            bw.newLine();
            for(Student student : students){
                bw.write(student.getName() + "," +
                        student.getAge() + "," +
                        student.getAddress() + "," +
                        student.getEmail());
                bw.newLine();
            }
            System.out.println("Students wriitten to CSV file");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
