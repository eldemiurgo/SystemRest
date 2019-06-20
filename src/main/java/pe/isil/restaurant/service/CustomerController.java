package pe.isil.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.restaurant.repository.JdbcCustomerRepository;

@Controller
public class CustomerController {

 @Autowired
 JdbcCustomerRepository jdbcCustomerRepository;


    @GetMapping( {"/", "/login"})
    public String index(){
        return "eliteadmin-wpmenu/login";
    }

}
