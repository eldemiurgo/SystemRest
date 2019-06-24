package pe.isil.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.restaurant.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}