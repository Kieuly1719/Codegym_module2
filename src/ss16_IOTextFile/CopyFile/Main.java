package ss16_IOTextFile.CopyFile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        String InputFilePath = "src/ss16_IOTextFile/CopyFile/files/input.txt";
        String OutputFilePath = "src/ss16_IOTextFile/CopyFile/files/output.txt";
        File input = new File(InputFilePath);
        File output = new File(OutputFilePath);
        try{
            if(!input.exists()){
                System.err.println("Lỗi: File nguồn không tồn tại!");
                return;
            }if(output.exists()){
                output.delete();
            }
            copyFile(input,output);
        }catch (Exception e) {
            System.err.println("Đã xảy ra lỗi trong quá trình copy file.");
            e.printStackTrace();
        }
    }
    public static void copyFile(File input, File output) {
        try(FileWriter fw = new FileWriter(output);
            FileReader fr = new FileReader(input);){
            int character;
            int count = 0;
            while((character = fr.read()) != -1){
                fw.write(character);
                count++;
            }
            System.out.println("Tổng số ký tự đã copy: " + count);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
