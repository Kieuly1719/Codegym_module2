package CustomerManagement.service;

import CustomerManagement.entity.Customer;
import CustomerManagement.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private CustomerRepository  customerRepository = new CustomerRepository();

    @Override
    public void addCustomer(Customer customer) {
        if(customer == null){
            throw new IllegalArgumentException("Thông tin khách hàng không được để trống");
        }
        if(customerRepository.findId(customer.getId())){
            throw new IllegalArgumentException("ID khách hàng đã tồn tại");
        }
        customerRepository.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        if (customer == null) {
            throw new NullPointerException("Customer is null");
        }
        customerRepository.deleteCustomer(customer.getId());
    }

    @Override
    public void updateCustomer(Customer newInfomation) {
        if (newInfomation == null || !customerRepository.findId(newInfomation.getId())) {
            throw new IllegalArgumentException("Không tìm thấy khách hàng để cập nhập");
        }
        if(customerRepository.findId(newInfomation.getId())){
            customerRepository.updateCustomer(newInfomation);
        }
        else{
            throw new IllegalArgumentException("ID khách hàng khng tồn tại!");
        }
    }

    @Override
    public List<Customer> getListCustomer() {
        return customerRepository.getListCustomers();
    }

    public Customer getCustomerById(String id) {
        Customer customer = customerRepository.getCustomerById(id);
        if(customer == null){
            throw new IllegalArgumentException("Không tìm thấy khách hàng");
        }
        return customer;
    }
    @Override
    public List<Customer> searchCustomerByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên tìm kiếm không được để trống");
        }
        return customerRepository.searchCustomerByName(name);
    }
}
