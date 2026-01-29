package PoliceManagement.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFile<T> {
    public static <T> void WriteToFile(String fileName, List<T> list, boolean append){
        File file = new File(fileName);
        try(FileWriter fw = new FileWriter(file, append);
            BufferedWriter bw = new BufferedWriter(fw)){
            for (T t : list) {
                bw.write(t.toString());
                bw.newLine();
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    public static List<String> ReadFile(String fileName){
        File file = new File(fileName);
        List<String> list = new ArrayList<>();
        try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)){
            String line = null;
            while((line = br.readLine()) != null){
                list.add(line);
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return list;
    }
}
