package FuramaManagement.service;

import FuramaManagement.entity.Customer;
import FuramaManagement.repository.IRepository;

import java.util.List;

public interface ICustomerService extends IService<Customer> {
    Customer findByCustomer_ID(String customer_ID);
}
