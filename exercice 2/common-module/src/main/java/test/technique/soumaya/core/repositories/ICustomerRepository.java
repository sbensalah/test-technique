package test.technique.soumaya.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import test.technique.soumaya.core.entities.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Long>{
	
	@Query("select c from Customer c where lower(c.last_name) like lower(:pLast_name)")
	Optional<Customer> findBylast_name(@Param("pLast_name") String last_name);
}
