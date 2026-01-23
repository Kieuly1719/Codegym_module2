package CustomerManagement.repository;

import CustomerManagement.entity.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final String FILE_PATH = "src/CustomerManagement/files/Customer.csv";
    private List<Customer> customers = new ArrayList<>();
    public CustomerRepository() {
        loadDataFromFileToList();
    }
    public List<Customer> getListCustomers() {
        return customers;
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveDataToFile();
    }
    public void updateCustomer(Customer customer) {
        for(Customer cus : customers){
            if(cus.getId().equals(customer.getId())){
                cus.setName(customer.getName());
                cus.setAddress(customer.getAddress());
                cus.setType(customer.getType());
                saveDataToFile();
                return;
            }
        }
    }
    public void deleteCustomer(String id){
        for(Customer cus : customers){
            if(cus.getId().equals(id)){
                customers.remove(cus);
                break;
            }
        }
        saveDataToFile();
    }
    public boolean findId(String id){
        for(Customer cus : customers){
            if(cus.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    public Customer getCustomerById(String id){
        for(Customer cus : customers){
            if(cus.getId().equals(id)){
                return cus;
            }
        }
        return null;
    }
    public List<Customer> searchCustomerByName(String keyword){
        List<Customer> results = new ArrayList<>();
        for(Customer cus : customers){
            if(cus.getName().toLowerCase().contains(keyword.toLowerCase())){
                results.add(cus);
            }
        }
        return results;
    }
    private void loadDataFromFileToList(){
        File file = new File(FILE_PATH);
        if(!file.exists()){
            return;
        }
        try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)){
            String line;
            while((line = br.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                String[] parts = line.split(",");
                if(parts.length == 4){
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    int type = Integer.parseInt(parts[2].trim());
                    String address = parts[3].trim();

                    Customer cus = new Customer(id, name, type, address);
                    customers.add(cus);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void saveDataToFile(){
        try(FileWriter fw = new FileWriter(FILE_PATH);
        BufferedWriter bw = new BufferedWriter(fw)){
            for(Customer cus: customers){
                bw.write(cus.getId() + "," + cus.getName()
                + "," + cus.getType() + "," + cus.getAddress());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
