package CustomerManagement.service;

import CustomerManagement.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerService {
    void addCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    void updateCustomer(Customer customer);
    List<Customer> getListCustomer();
    Customer getCustomerById(String id);
    List<Customer> searchCustomerByName(String name);
}
