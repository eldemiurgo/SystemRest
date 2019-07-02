package pe.isil.restaurant.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
    private Integer idCliente;
    private String razonSocial;
    private String tipoDoc;
    private String numDoc;
    private String Email;

}
