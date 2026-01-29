package FuramaManagement.service;

import FuramaManagement.entity.Customer;
import FuramaManagement.repository.CustomerRepository;
import FuramaManagement.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean add(Customer customer) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer cus : customers) {
            if(cus.getID().equals(customer.getID())){
                return false;
            }
        }
        customerRepository.add(customer);
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer cus : customers) {
            if(cus.getID().equals(customer.getID())){
                customerRepository.update(customer);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer cus : customers) {
            if(cus.getID().equals(id)){
                customerRepository.delete(id);
                return true;
            }
        }
        return false;
    }
    @Override
    public Customer findByCustomer_ID(String customer_ID){
        List<Customer> customers = customerRepository.findAll();
        for(Customer cus : customers){
            if(cus.getID().equals(customer_ID)){
                return cus;
            }
        }
        return null;
    }
}
