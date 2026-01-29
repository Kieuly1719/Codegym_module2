package FuramaManagement.service;

import FuramaManagement.entity.Booking;
import FuramaManagement.entity.Customer;

import java.time.LocalDate;
import java.util.*;

public class PromotionService implements IPromotionService {
    private final IBookingService bookingService = new BookingService();
    private final ICustomerService customerService = new CustomerService();

    @Override
    public List<Customer> displayListCustomerUseService(int year) {
        List<Booking> bookings = bookingService.findAll();
        Set<String> customerIds = new TreeSet<>();
        for(Booking book : bookings) {
            if(book.getStartDate().getYear() == year){
                customerIds.add(book.getCustomer_ID());
            }
        }
        List<Customer> customers = customerService.findAll();
        List<Customer> kq = new ArrayList<>();
        for(String id : customerIds){
            for(Customer customer : customers){
                if(id.equals(customer.getID())){
                    kq.add(customer);
                    break;
                }
            }
        }
        return kq;

    }

    @Override
    public List<Customer> displayListCustomersGetVoucher(int voucher10, int voucher20, int voucher50) {
        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        List<Booking> bookings = bookingService.findAll();
        Stack<Booking> bookingStack = new Stack<>();
        for(Booking book : bookings){
            if(book.getStartDate().getMonthValue() == currentMonth && book.getStartDate().getYear() == currentYear){
                bookingStack.push(book);
            }
        }
        Set<String> customerIdsReceive = new HashSet<>();
        List<Customer> customerReceive = new ArrayList<>();
        int v10 = 0;
        int v20 = 0;
        int v50 = 0;
        Booking book;
        String cusId;
        while(!bookingStack.isEmpty()){
            book = bookingStack.pop();
            cusId = book.getCustomer_ID();
            if(!customerIdsReceive.contains(cusId)){
                if(v10 < voucher10){
                    customerIdsReceive.add(cusId);
                    customerReceive.add(customerService.findByCustomer_ID(cusId));
                    v10++;
                }
                else if(v20 < voucher20){
                    customerIdsReceive.add(cusId);
                    customerReceive.add(customerService.findByCustomer_ID(cusId));
                    v20++;
                }
                else if(v50 < voucher50){
                    customerIdsReceive.add(cusId);
                    customerReceive.add(customerService.findByCustomer_ID(cusId));
                    v50++;
                }
                else{
                    break;
                }
            }
        }
        return customerReceive;
    }
}
