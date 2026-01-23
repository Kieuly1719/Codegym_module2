package CustomerManagement.view;

import CustomerManagement.controller.CustomerController;

public class Main {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.displayMain();
    }
}
