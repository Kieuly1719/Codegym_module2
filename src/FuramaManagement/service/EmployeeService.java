package FuramaManagement.service;

import FuramaManagement.entity.Employee;
import FuramaManagement.repository.EmployeeRepository;
import FuramaManagement.repository.IEmployeeRepository;
import FuramaManagement.util.UserException;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean add(Employee employee) {
        List<Employee> employeeList = employeeRepository.findAll();
        for(Employee e: employeeList) {
            if(e.getID().equals(employee.getID())) {
                return false;
            }
        }
        employeeRepository.add(employee);
        return true;
    }

    @Override
    public boolean update(Employee employee) {
        List<Employee> employeeList = employeeRepository.findAll();
        for(Employee e: employeeList) {
            if(e.getID().equals(employee.getID())) {
                employeeRepository.update(employee);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try{
            boolean exists = checkIdExists(id);
            if(!exists) {
                throw new UserException("Nhân viên có ID " + id + " không tồn tại!");
            }
            employeeRepository.delete(id);
            return true;
        } catch (UserException e){
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi hệ thống.");
            return false;
        }
    }

    @Override
    public Employee findEmployeeByID(String id) {
        List<Employee> employeeList = employeeRepository.findAll();
        for(Employee e: employeeList) {
            if(e.getID().equals(id)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public boolean checkIdExists(String id) {
        List<Employee> employeeList = employeeRepository.findAll();
        for(Employee e: employeeList) {
            if(e.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
