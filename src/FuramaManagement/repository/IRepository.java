package FuramaManagement.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    void add(T t);
    void update(T t);
    void delete(String id);
}
