package FuramaManagement.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static <T> void writeToFile(String pathFile, List<T> list, boolean append){
        File file = new File(pathFile);
        try(FileWriter fw = new FileWriter(file, append);
            BufferedWriter bw = new BufferedWriter(fw)){
            if(append) {
                for (T t : list) {
                    bw.newLine();
                    bw.write(t.toString());
                }
            }
            else{
                for (T t : list) {
                    bw.write(t.toString());
                    bw.newLine();
                }
            }
        }catch(IOException e){
            System.out.println("Lỗi:: Ghi file không thành công");
        }
    }
    public static List<String> readFile(String pathFile){
        List<String> list = new ArrayList<>();
        File file = new File(pathFile);
        if (!file.exists()) {
            return list;
        }
        try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)){
            String line;
            while((line = br.readLine()) != null){
                list.add(line);
            }
        }catch(IOException e){
            System.out.println("Lỗi: Ghi file không thành công");
        }
        return list;
    }
}
