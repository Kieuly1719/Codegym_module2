package FuramaManagement.service;

import FuramaManagement.entity.Customer;

import java.util.List;

public interface IPromotionService {
    List<Customer> displayListCustomerUseService(int year);
    List<Customer> displayListCustomersGetVoucher(int voucher10, int voucher20, int voucher50);
}
