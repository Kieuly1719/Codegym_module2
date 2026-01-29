package FuramaManagement.service;

import FuramaManagement.entity.Booking;
import FuramaManagement.entity.Facility;
import FuramaManagement.repository.BookingRepository;
import FuramaManagement.repository.FacilityRepository;
import FuramaManagement.repository.IBookingRepository;
import FuramaManagement.repository.IFacilityRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityService implements IFacilityService {
    private final IFacilityRepository facilityRepository = new FacilityRepository();
    private final IBookingRepository bookingRepository = new BookingRepository();
    @Override
    public Map<Facility, Integer> findAllMap() {
        Map<Facility, Integer> facilityMap = facilityRepository.getFacilityMap();

        List<Booking> bookingList = bookingRepository.findAll();

        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            int count = 0;
            String currentServiceId = entry.getKey().getService_id();

            for (Booking booking : bookingList) {
                if (booking.getService_name().equals(currentServiceId)) {
                    count++;
                }
            }
            entry.setValue(count);
        }

        return facilityMap;
    }

    @Override
    public Map<Facility, Integer> findMaintenaceList() {
        Map<Facility, Integer> allFacilities = findAllMap();
        Map<Facility, Integer> maintenanceList = new LinkedHashMap<>();

        for (Map.Entry<Facility, Integer> entry : allFacilities.entrySet()) {
            if (entry.getValue() >= 5) {
                maintenanceList.put(entry.getKey(), entry.getValue());
            }
        }
        return maintenanceList;
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public boolean add(Facility facility) {
        List<Facility> facilities = facilityRepository.findAll();
        for (Facility fac : facilities) {
            if (fac.getService_id().equals(facility.getService_id())) {
                return false;
            }
        }
        facilityRepository.add(facility);
        return true;
    }

    @Override
    public boolean update(Facility facility) {
        List<Facility> facilities = facilityRepository.findAll();
        for (Facility fac : facilities) {
            if (fac.getService_id().equals(facility.getService_id())) {
                facilityRepository.update(facility);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        List<Facility> facilities = facilityRepository.findAll();
        for (Facility fac : facilities) {
            if (fac.getService_id().equals(id)) {
                facilityRepository.delete(id);
                return true;
            }
        }
        return false;
    }
}
