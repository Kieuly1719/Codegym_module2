package FuramaManagement.repository;

import FuramaManagement.entity.Facility;

import java.util.Map;

public interface IFacilityRepository extends IRepository<Facility> {
    Map<Facility, Integer> getFacilityMap();
}
