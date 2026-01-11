package CaseStudy.Controller;

import java.util.Scanner;

public class FuramaController {
    public void displayMainMenu(){
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do?");
        int choice = sc.nextLine().charAt(0);
        switch(choice){
            case 1:
                displayEmployeeManagement();
                break;
            case 2:
                displayCustomerManagement();
                break;
            case 3:
                displayFacilityManagement();
                break;
            case 4:
                displayBookingManagement();
                break;
            case 5:
                displayPromotionManagement();
                break;
            case 6:
                break;
        }
    }

    public void displayEmployeeManagement(){
        System.out.println("1. Display list employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Delete employee");
        System.out.println("4. Edit employee");
        System.out.println("5. Return main menu");

        System.out.println("What would you like to do?");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextLine().charAt(0);
        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
    public void displayCustomerManagement(){
        System.out.println("1. Display list customers");
        System.out.println("2. Add new customer");
        System.out.println("3. Edit customer");
        System.out.println("5. Return main menu");

        System.out.println("What would you like to do?");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextLine().charAt(0);
        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
    public void displayFacilityManagement(){
        System.out.println("1. Display list facilities");
        System.out.println("2. Add new facility");
        System.out.println("3. Display list facilities maintenance");
        System.out.println("4. Return main menu");

        System.out.println("What would you like to do?");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextLine().charAt(0);
        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
    public void displayBookingManagement(){
        System.out.println("1. Add new booking");
        System.out.println("2. Display list bookings");
        System.out.println("3. Return main menu");

        System.out.println("What would you like to do?");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextLine().charAt(0);
        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
    public void displayPromotionManagement(){
        System.out.println("1. Display list customer use service");
        System.out.println("2. Display list customers get voucher");
        System.out.println("3. Return main menu");

        System.out.println("What would you like to do?");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextLine().charAt(0);
        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
}
