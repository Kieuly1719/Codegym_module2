package FuramaManagement.service;

import FuramaManagement.entity.Booking;
import FuramaManagement.repository.BookingRepository;
import FuramaManagement.repository.IBookingRepository;

import java.util.List;

public class BookingService implements IBookingService{
    private final IBookingRepository bookingRepository = new BookingRepository();
    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public boolean add(Booking booking) {
        List<Booking> bookings = bookingRepository.findAll();
        for (Booking book : bookings) {
            if(book.getBooking_ID().equals(booking.getBooking_ID())){
                return false;
            }
        }
        bookingRepository.add(booking);
        return true;
    }

    @Override
    public boolean update(Booking booking) {
        List<Booking> bookings = bookingRepository.findAll();
        for (Booking book : bookings) {
            if(book.getBooking_ID().equals(booking.getBooking_ID())){
                bookingRepository.update(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        List<Booking> bookings = bookingRepository.findAll();
        for (Booking book : bookings) {
            if(book.getBooking_ID().equals(id)){
                bookingRepository.delete(id);
                return true;
            }
        }
        return false;
    }
}
