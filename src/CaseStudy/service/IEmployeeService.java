package CaseStudy.service;

import CaseStudy.entity.Employee;

public interface IEmployeeService extends IService<Employee> {
    void delete(Employee e);
    void edit(Employee e);
}
