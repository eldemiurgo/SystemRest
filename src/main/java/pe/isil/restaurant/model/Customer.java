package pe.isil.restaurant.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String users;
    private String passwords;
}