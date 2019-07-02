package pe.isil.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.restaurant.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}