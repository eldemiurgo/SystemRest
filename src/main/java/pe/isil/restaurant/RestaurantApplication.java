package pe.isil.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.isil.restaurant.model.Customer;
import pe.isil.restaurant.repository.CustomerRepository;

@Slf4j
@SpringBootApplication
public class RestaurantApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;



    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {





        log.info("terminate!");
    }


}
