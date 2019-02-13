package ec.com.kruger.performance.db.mongo.repository;

import ec.com.kruger.performance.db.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerMongoRepository extends MongoRepository<Customer, String> {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
