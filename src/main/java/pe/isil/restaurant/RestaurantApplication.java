package pe.isil.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.isil.restaurant.model.Customer;
import pe.isil.restaurant.repository.JdbcCustomerRepository;

import java.util.List;

@Slf4j
@SpringBootApplication
public class RestaurantApplication implements CommandLineRunner {

    @Autowired
    private JdbcCustomerRepository jdbcCustomerRepository;


    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        jdbcCustomerRepository
                .create(new Customer(null, "CARMEN", "CABANA", "Jr. eleodoro zeballos", "948682821",
                        "root","password"));


        Customer customer = jdbcCustomerRepository
                .findById(2L);

        log.info("customer={}", customer);

        customer.setName("Ronny");

        jdbcCustomerRepository
                .update(customer);

        jdbcCustomerRepository.delete(1L);

        List<Customer> customerList = jdbcCustomerRepository
                .findAll();

        log.info("customerList =>{}", customerList);

        log.info("terminate!");
    }
}
