package FuramaManagement.repository;

import FuramaManagement.entity.Booking;
import FuramaManagement.util.DateConverter;
import FuramaManagement.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BookingRepository implements IBookingRepository {
    private final String BOOKING_FILE = "src/FuramaManagement/data/Booking.csv";
    @Override
    public List<Booking> findAll() {
        Set<Booking> bookingSet = new TreeSet<>();
        List<String> bookings = ReadAndWriteFile.readFile(BOOKING_FILE);
        String[] parts = null;
        for(String line : bookings){
            parts = line.split(",");
            bookingSet.add(new Booking(parts[0], DateConverter.stringToDate(parts[1]), DateConverter.stringToDate(parts[2]),parts[3],parts[4]));
        }
        return new ArrayList<>(bookingSet);
    }

    @Override
    public void add(Booking booking) {
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(booking);
        ReadAndWriteFile.writeToFile(BOOKING_FILE,bookingList,true);
    }

    @Override
    public void update(Booking booking) {
        List<Booking> bookingList = findAll();
        for(int i = 0; i < bookingList.size(); i++){
            if(bookingList.get(i).getBooking_ID().equals(booking.getBooking_ID())){
                bookingList.set(i, booking);
                break;
            }
        }
        ReadAndWriteFile.writeToFile(BOOKING_FILE,bookingList,false);
    }

    @Override
    public void delete(String id) {
        List<Booking> bookingList = findAll();
        for(Booking book : bookingList){
            if(book.getBooking_ID().equals(id)){
                bookingList.remove(book);
                break;
            }
        }
        ReadAndWriteFile.writeToFile(BOOKING_FILE,bookingList,false);
    }
}
