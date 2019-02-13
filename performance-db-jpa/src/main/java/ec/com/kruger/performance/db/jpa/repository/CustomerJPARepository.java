package ec.com.kruger.performance.db.jpa.repository;

import ec.com.kruger.performance.db.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerJPARepository extends JpaRepository<Customer,String> {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
