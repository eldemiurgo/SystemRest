package pe.isil.restaurant.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String user;
    private String password;
}