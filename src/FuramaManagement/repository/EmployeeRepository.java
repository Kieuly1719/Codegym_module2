package FuramaManagement.repository;

import FuramaManagement.entity.Employee;
import FuramaManagement.util.DateConverter;
import FuramaManagement.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String Employee_Path = "src/FuramaManagement/data/Employee.csv";
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        List<String> list = ReadAndWriteFile.readFile(Employee_Path);
        String[] parts = null;
        for(String line : list){
            parts = line.split(",");
            employees.add(new Employee(parts[0], parts[1], DateConverter.stringToDate(parts[2]), Integer.parseInt(parts[3]), parts[4], parts[5], parts[6], Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), Double.parseDouble(parts[9])));
        }
        return employees;
    }

    @Override
    public void add(Employee employee) {
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        ReadAndWriteFile.writeToFile(Employee_Path, employees, true);
    }
    @Override
    public void update(Employee employee) {
        List<Employee> employees = findAll();
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getID().equals(employee.getID())){
                employees.set(i,employee);
                break;
            }
        }
        ReadAndWriteFile.writeToFile(Employee_Path, employees, false);
    }

    @Override
    public void delete(String id) {
        List<Employee> employees = findAll();
        for(Employee e : employees){
            if(e.getID().equals(id)){
                employees.remove(e);
                break;
            }
        }
        ReadAndWriteFile.writeToFile(Employee_Path, employees, false);
    }
}
