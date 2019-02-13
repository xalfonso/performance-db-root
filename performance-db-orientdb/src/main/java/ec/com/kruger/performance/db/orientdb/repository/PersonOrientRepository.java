package ec.com.kruger.performance.db.orientdb.repository;

import ec.com.kruger.performance.db.model.Person;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("generatedPersonRepository")
public interface PersonOrientRepository extends OrientObjectRepository<Person> {
	Person findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);
}
