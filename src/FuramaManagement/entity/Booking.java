package FuramaManagement.entity;

import FuramaManagement.util.DateConverter;

import java.time.LocalDate;
import java.util.Date;

public class Booking implements Comparable<Booking>, IDisplay{
    private String Booking_ID;
    private LocalDate startDate;
    private LocalDate endDate;
    private String customer_ID;
    private String service_name;

    public Booking(String booking_ID, LocalDate startDate, LocalDate endDate, String customer_ID, String service_name) {
        Booking_ID = booking_ID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer_ID = customer_ID;
        this.service_name = service_name;
    }

    public Booking() {
    }

    public String getBooking_ID() {
        return Booking_ID;
    }

    public void setBooking_ID(String booking_ID) {
        Booking_ID = booking_ID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String displayOb(){
        return "\nBooking: " +
                "\n1. Booking ID: " + getBooking_ID() +
                "\n2. Start Date: " + getStartDate() +
                "\n3. End Date: " + getEndDate() +
                "\n4. Customer ID: " + getCustomer_ID() +
                "\n5. Service name: " + getService_name();
    }
    @Override
    public String toString() {
        return Booking_ID + "," + DateConverter.dateToString(startDate) + "," + DateConverter.dateToString(endDate) + "," + customer_ID + "," + service_name;
    }

    @Override
    public int compareTo(Booking o) {
        int startCompare = this.startDate.compareTo(o.startDate);
        if(startCompare != 0){
            return startCompare;
        }
        int endCompare = this.endDate.compareTo(o.endDate);
        if(endCompare != 0){
            return endCompare;
        }
        return this.Booking_ID.compareTo(o.Booking_ID);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Booking_ID.equals(booking.Booking_ID);
    }
    @Override
    public int hashCode() {
        return Booking_ID.hashCode();
    }
}
