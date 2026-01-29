package FuramaManagement.service;

import FuramaManagement.entity.Facility;
import FuramaManagement.repository.IRepository;

import java.util.Map;

public interface IFacilityService extends IService<Facility> {
    Map<Facility, Integer> findAllMap();
    Map<Facility, Integer> findMaintenaceList();
}
