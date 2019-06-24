package pe.isil.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.restaurant.repository.CustomerRepository;

@Controller
public class CustomerController {

 @Autowired
 CustomerRepository customerRepository;


    @GetMapping( {"/", "/login"})
    public String login(){
        return "login";
    }

    @GetMapping( {"/index"})
    public String index(){
        return "index";
    }

}
