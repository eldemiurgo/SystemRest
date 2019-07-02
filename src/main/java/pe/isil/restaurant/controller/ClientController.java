package pe.isil.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.restaurant.model.Client;
import pe.isil.restaurant.repository.JdbcClientRepository;

@Controller
public class ClientController {


    @Autowired
    JdbcClientRepository jdbcClientRepository;

    @GetMapping( {"/", "/index"})
    public String index(){
        return "index";
    }


    @GetMapping("/clients")
    public String getAll(Model model){
        model.addAttribute("clients", jdbcClientRepository.findAll());
        return "client";
    }

    @GetMapping("/clients/add")
    public String create(Model model){
        model.addAttribute("client", new Client());
        return "client-add";
    }

    @PostMapping("/clients/save")
    public String update(Client client, Model model){

        jdbcClientRepository.create(client);

        model.addAttribute("clients", jdbcClientRepository.findAll());

        return "client";
    }

    @GetMapping("/clients/edit/{idClient}")
    public String getProductForEdit(@PathVariable Integer  idClient,
                                    Model model){
        model.addAttribute("client",
                jdbcClientRepository.findById(idClient));
        return "client-edit";
    }

    @PostMapping("/clients/update/{idClient}")
    public String update(@PathVariable Integer idClient,
                         Client client,
                         Model model){
        jdbcClientRepository.update(client);
        model.addAttribute("clients",
                jdbcClientRepository.findAll());
        return "client";
    }

    @GetMapping("/clients/delete/{idClient}")
    public String delete(@PathVariable Integer idClient,
                         Model model){
        jdbcClientRepository.delete(idClient);
        model.addAttribute("clients",
                jdbcClientRepository.findAll());
        return "client";
    }
}
