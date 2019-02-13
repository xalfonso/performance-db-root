package ec.com.kruger.performance.db.orientdb.repository;

import ec.com.kruger.performance.db.model.Customer;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("generatedCustomerRepository")
public interface CustomerOrientRepository extends OrientObjectRepository<Customer> {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
