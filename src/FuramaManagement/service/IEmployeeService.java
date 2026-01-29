package FuramaManagement.service;

import FuramaManagement.entity.Employee;
import FuramaManagement.repository.IRepository;

public interface IEmployeeService extends IService<Employee> {
    Employee findEmployeeByID(String id);
    boolean checkIdExists(String id);
}
