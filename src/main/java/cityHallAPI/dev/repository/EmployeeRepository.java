package cityHallAPI.dev.repository;

import cityHallAPI.dev.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public Optional<Employee> findByEmployeeIdAndPassword(int employeeId, String password);
    public Optional <Employee> findByDocument(String document);
}
