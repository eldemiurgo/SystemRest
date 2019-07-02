package pe.isil.restaurant.repository;

import org.springframework.stereotype.Repository;
import pe.isil.restaurant.model.Client;

@Repository
public interface ClientRepository  extends BaseRepository<Client, Integer> {
}
