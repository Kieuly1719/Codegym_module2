package FuramaManagement.repository;

import FuramaManagement.entity.Customer;
import FuramaManagement.util.DateConverter;
import FuramaManagement.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String CUSTOMER_FILE = "src/FuramaManagement/data/Customer.csv";
    @Override
    public List<Customer> findAll() {
        List<String> customers = ReadAndWriteFile.readFile(CUSTOMER_FILE);
        List<Customer> customerList = new LinkedList<>();
        String[] parts = null;
        for(String customer : customers){
            parts = customer.split(",");
            customerList.add(new Customer(parts[0], parts[1], DateConverter.stringToDate(parts[2]), Integer.parseInt(parts[3]),
                    parts[4],parts[5],parts[6],Integer.parseInt(parts[7]),parts[8]));
        }
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        ReadAndWriteFile.writeToFile(CUSTOMER_FILE, customers, true);
    }

    @Override
    public void update(Customer customer) {
        List<Customer> customers = findAll();
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getID().equals(customer.getID())){
                customers.set(i,customer);
                break;
            }
        }
        ReadAndWriteFile.writeToFile(CUSTOMER_FILE, customers, false);
    }

    @Override
    public void delete(String id) {
        List<Customer> customers = findAll();
        for(Customer cus : customers){
            if(cus.getID().equals(id)){
                customers.remove(cus);
                break;
            }
        }
        ReadAndWriteFile.writeToFile(CUSTOMER_FILE, customers, false);
    }
}
