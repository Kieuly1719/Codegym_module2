package ss16_IOTextFile.Demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pathFile = "src/ss16_IOTextFile/Demo/files/demo.txt";
        List<String> ct = new ArrayList<>();
        ct.add("hello");
        ct.add("Toi la Kieu Ly");
        ct.add("Toi hoc dai hoc Bach Khoa");
//        writeFile(pathFile, ct);
        readFile(pathFile);
    }
    private static void readFile(String pathFile){
        try(FileReader fr = new FileReader(pathFile);
            BufferedReader br = new BufferedReader(fr)){
            String line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    private static void writeFile(String pathFile, List<String> ct){
        try(FileWriter fw = new FileWriter(pathFile);
            BufferedWriter bw = new BufferedWriter(fw)){
            for(String line : ct){
                bw.write(line);
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
