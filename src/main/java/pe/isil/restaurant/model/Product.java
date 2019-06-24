package pe.isil.restaurant.model;


import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Product {
    private Long id;
    private String description;
    private String type;
    private float price;
}