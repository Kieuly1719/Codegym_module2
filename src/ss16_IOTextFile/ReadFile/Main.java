package ss16_IOTextFile.ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/ss16_IOTextFile/ReadFile/files/input.csv";
        ReadFile(filePath);
    }
    private static void ReadFile(String filePath) {
        try(FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)){
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                Country country = new Country();
                country.setId(Integer.parseInt(data[0]));
                country.setCode(data[1]);
                country.setName(data[2]);
                System.out.println(country);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
